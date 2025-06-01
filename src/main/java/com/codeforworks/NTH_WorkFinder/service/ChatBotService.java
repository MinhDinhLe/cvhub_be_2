package com.codeforworks.NTH_WorkFinder.service;

import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.codeforworks.NTH_WorkFinder.model.ChatbotRule;
import com.codeforworks.NTH_WorkFinder.repository.ChatbotRuleRepository;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole; 
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatBotService {
    
    private final ChatbotRuleRepository chatbotRuleRepository;
    
    public String processMessage(String message) {
        log.info("Processing message: {}", message);
        
        String normalizedMessage = normalizeMessage(message);
        log.debug("Normalized message: {}", normalizedMessage);
        
        // Tìm rule phù hợp nhất
        ChatbotRule matchedRule = findBestMatch(normalizedMessage);
        if (matchedRule != null) {
            log.info("Found matching rule: {}", matchedRule.getPattern());
            return matchedRule.getResponse();
        }
        
        log.info("No matching rule found");
        return "Xin lỗi, tôi chỉ có thể trả lời các câu hỏi liên quan đến tuyển dụng và tìm việc.";
    }
    
    private String normalizeMessage(String message) {
        return message.toLowerCase()
                     .trim()
                     .replaceAll("\\s+", " ");
    }
    
    private ChatbotRule findBestMatch(String message) {
        List<ChatbotRule> rules = chatbotRuleRepository.findAllByOrderByPriorityDesc();
        
        for (ChatbotRule rule : rules) {
            Pattern pattern = Pattern.compile(rule.getPattern(), Pattern.CASE_INSENSITIVE);
            if (pattern.matcher(message).find()) {
                return rule;
            }
        }
        return null;
    }
} 
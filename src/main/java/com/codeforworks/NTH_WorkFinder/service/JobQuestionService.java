package com.codeforworks.NTH_WorkFinder.service;

import com.codeforworks.NTH_WorkFinder.dto.JobQuestionDTO;
import com.codeforworks.NTH_WorkFinder.dto.JobAnswerDTO;
import com.codeforworks.NTH_WorkFinder.model.JobQuestion;
import com.codeforworks.NTH_WorkFinder.model.JobAnswer;
import com.codeforworks.NTH_WorkFinder.repository.JobQuestionRepository;
import com.codeforworks.NTH_WorkFinder.repository.JobAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobQuestionService {

    @Autowired
    private JobQuestionRepository questionRepository;

    @Autowired
    private JobAnswerRepository answerRepository;

    @Transactional
    public JobQuestionDTO createQuestion(JobQuestionDTO questionDTO) {
        JobQuestion question = new JobQuestion();
        question.setJobCode(questionDTO.getJobCode());
        question.setQuestionText(questionDTO.getQuestionText());
        
        JobQuestion savedQuestion = questionRepository.save(question);
        return convertToDTO(savedQuestion);
    }

    @Transactional
    public JobAnswerDTO createAnswer(JobAnswerDTO answerDTO) {
        JobAnswer answer = new JobAnswer();
        answer.setAnswerText(answerDTO.getAnswerText());
        answer.setIsCorrect(answerDTO.getIsCorrect());
        
        JobQuestion question = questionRepository.findById(answerDTO.getQuestionId())
            .orElseThrow(() -> new RuntimeException("Question not found"));
        answer.setQuestion(question);
        
        JobAnswer savedAnswer = answerRepository.save(answer);
        return convertToDTO(savedAnswer);
    }

    public List<JobQuestionDTO> getQuestionsByJobCode(Long jobCode) {
        return questionRepository.findByJobCode(jobCode).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public List<JobAnswerDTO> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId).stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private JobQuestionDTO convertToDTO(JobQuestion question) {
        JobQuestionDTO dto = new JobQuestionDTO();
        dto.setId(question.getId());
        dto.setJobCode(question.getJobCode());
        dto.setQuestionText(question.getQuestionText());
        dto.setCreatedAt(question.getCreatedAt());
        dto.setUpdatedAt(question.getUpdatedAt());
        
        if (question.getAnswers() != null) {
            dto.setAnswers(question.getAnswers().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }

    private JobAnswerDTO convertToDTO(JobAnswer answer) {
        JobAnswerDTO dto = new JobAnswerDTO();
        dto.setId(answer.getId());
        dto.setQuestionId(answer.getQuestion().getId());
        dto.setAnswerText(answer.getAnswerText());
        dto.setIsCorrect(answer.getIsCorrect());
        dto.setCreatedAt(answer.getCreatedAt());
        dto.setUpdatedAt(answer.getUpdatedAt());
        return dto;
    }
} 
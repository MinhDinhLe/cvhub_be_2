package com.codeforworks.NTH_WorkFinder.dto.chatbot;

import java.util.Date;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChatbotMessageDTO {
    private String content;      // Nội dung tin nhắn
    private MessageType type;    // Loại tin nhắn (USER/BOT)
    private String category;     // Category của câu hỏi/trả lời
    private boolean containsHtml; // Thêm trường này
} 
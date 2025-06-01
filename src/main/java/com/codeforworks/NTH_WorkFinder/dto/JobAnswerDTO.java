package com.codeforworks.NTH_WorkFinder.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class JobAnswerDTO {
    private Long id;
    private Long questionId;
    private String answerText;
    private Boolean isCorrect;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 
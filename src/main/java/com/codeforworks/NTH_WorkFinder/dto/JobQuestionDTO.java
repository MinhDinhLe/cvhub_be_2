package com.codeforworks.NTH_WorkFinder.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class JobQuestionDTO {
    private Long id;
    private Long jobCode;
    private String questionText;
    private List<JobAnswerDTO> answers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
} 
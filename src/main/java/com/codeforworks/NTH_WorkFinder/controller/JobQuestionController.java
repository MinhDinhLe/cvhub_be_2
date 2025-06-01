package com.codeforworks.NTH_WorkFinder.controller;

import com.codeforworks.NTH_WorkFinder.dto.JobQuestionDTO;
import com.codeforworks.NTH_WorkFinder.dto.JobAnswerDTO;
import com.codeforworks.NTH_WorkFinder.service.JobQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/job-questions")
@CrossOrigin(origins = "*")
public class JobQuestionController {

    @Autowired
    private JobQuestionService questionService;

    @PostMapping
    public ResponseEntity<JobQuestionDTO> createQuestion(@RequestBody JobQuestionDTO questionDTO) {
        return ResponseEntity.ok(questionService.createQuestion(questionDTO));
    }

    @PostMapping("/answers")
    public ResponseEntity<JobAnswerDTO> createAnswer(@RequestBody JobAnswerDTO answerDTO) {
        return ResponseEntity.ok(questionService.createAnswer(answerDTO));
    }

    @GetMapping("/job/{jobCode}")
    public ResponseEntity<List<JobQuestionDTO>> getQuestionsByJobCode(@PathVariable Long jobCode) {
        return ResponseEntity.ok(questionService.getQuestionsByJobCode(jobCode));
    }

    @GetMapping("/{questionId}/answers")
    public ResponseEntity<List<JobAnswerDTO>> getAnswersByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(questionService.getAnswersByQuestionId(questionId));
    }
} 
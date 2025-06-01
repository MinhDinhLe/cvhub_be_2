package com.codeforworks.NTH_WorkFinder.repository;

import com.codeforworks.NTH_WorkFinder.model.JobAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobAnswerRepository extends JpaRepository<JobAnswer, Long> {
    List<JobAnswer> findByQuestionId(Long questionId);
    List<JobAnswer> findByQuestionIdAndIsCorrect(Long questionId, Boolean isCorrect);
} 
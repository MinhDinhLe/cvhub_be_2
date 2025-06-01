package com.codeforworks.NTH_WorkFinder.repository;

import com.codeforworks.NTH_WorkFinder.model.JobQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobQuestionRepository extends JpaRepository<JobQuestion, Long> {
    List<JobQuestion> findByJobCode(Long jobCode);
} 
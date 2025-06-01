package com.codeforworks.NTH_WorkFinder.repository;

import com.codeforworks.NTH_WorkFinder.model.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
//JpaSpecificationExecutor để tìm kiếm công việc theo tiêu chí
public interface JobRepository extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> { 
    List<Job> findTopByOrderByViewCountDesc(Pageable pageable);
    List<Job> findByOrderByCreatedDateDesc(Pageable pageable);
    List<Job> findByExpiryDateBeforeAndIsActiveTrue(Date date);
    List<Job> findByEmployerId(Long employerId);
    int countByEmployerIdAndSubscriptionIdAndIsFeaturedFalse(Long employerId, Long subscriptionId);
    int countByEmployerIdAndSubscriptionIdAndIsFeaturedTrue(Long employerId, Long subscriptionId);
    @Query("SELECT COUNT(j) FROM Job j WHERE j.employer.id = :employerId AND j.isFeatured = false")
    int countByEmployerIdAndIsFeaturedFalse(@Param("employerId") Long employerId);
    @Query(value = "SELECT MAX(id) FROM job", nativeQuery = true)
    Long findMaxId();
}

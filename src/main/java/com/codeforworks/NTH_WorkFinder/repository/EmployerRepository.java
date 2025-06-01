package com.codeforworks.NTH_WorkFinder.repository;

import com.codeforworks.NTH_WorkFinder.model.Account;
import com.codeforworks.NTH_WorkFinder.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    @Query("SELECT e FROM Employer e WHERE " +
           "(:keyword IS NULL OR LOWER(e.companyName) LIKE %:keyword% OR LOWER(e.companyDescription) LIKE %:keyword%) AND " +
           "(:location IS NULL OR e.location = :location) AND " +
           "(:industryId IS NULL OR e.industry.id = :industryId)")
    List<Employer> searchEmployers(String keyword, String location, Long industryId);

    Optional<Employer> findByAccount(Account account);

    Optional<Employer> findByAccountEmail(String email);
}

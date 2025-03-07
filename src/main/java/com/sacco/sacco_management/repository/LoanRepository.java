package com.sacco.sacco_management.repository;

import com.sacco.sacco_management.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByApproved(Boolean approved);
}

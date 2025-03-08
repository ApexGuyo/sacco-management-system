package com.sacco.sacco_management.service;

import com.sacco.sacco_management.model.Loan;
import com.sacco.sacco_management.model.LoanRepayment;
import com.sacco.sacco_management.repository.LoanRepository;
import com.sacco.sacco_management.repository.LoanRepaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanRepaymentService {
    private final LoanRepaymentRepository loanRepaymentRepository;
    private final LoanRepository loanRepository;

    public LoanRepaymentService(LoanRepaymentRepository loanRepaymentRepository, LoanRepository loanRepository) {
        this.loanRepaymentRepository = loanRepaymentRepository;
        this.loanRepository = loanRepository;
    }

    public List<LoanRepayment> getAllRepayments() {
        return loanRepaymentRepository.findAll();
    }

    public List<LoanRepayment> getRepaymentsByLoanId(Long loanId) {
        return loanRepaymentRepository.findByLoanId(loanId);
    }

    public LoanRepayment makeRepayment(Long loanId, LoanRepayment repayment) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isPresent()) {
            repayment.setLoan(loan.get());
            return loanRepaymentRepository.save(repayment);
        } else {
            throw new RuntimeException("Loan not found!");
        }
    }
}

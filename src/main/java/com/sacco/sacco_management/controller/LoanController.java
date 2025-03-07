package com.sacco.sacco_management.controller;

import com.sacco.sacco_management.model.Loan;
import com.sacco.sacco_management.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {
        Optional<Loan> loan = loanService.getLoanById(id);
        return loan.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{memberId}")
    public ResponseEntity<Loan> requestLoan(@PathVariable Long memberId, @RequestBody Loan loanRequest) {
        try {
            Loan loan = loanService.requestLoan(memberId, loanRequest);
            return ResponseEntity.ok(loan);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{loanId}/approve")
    public ResponseEntity<Loan> approveLoan(@PathVariable Long loanId) {
        try {
            Loan approvedLoan = loanService.approveLoan(loanId);
            return ResponseEntity.ok(approvedLoan);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

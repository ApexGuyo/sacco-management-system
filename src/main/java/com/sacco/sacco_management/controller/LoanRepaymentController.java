package com.sacco.sacco_management.controller;

import com.sacco.sacco_management.model.LoanRepayment;
import com.sacco.sacco_management.service.LoanRepaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repayments")
public class LoanRepaymentController {
    private final LoanRepaymentService loanRepaymentService;

    public LoanRepaymentController(LoanRepaymentService loanRepaymentService) {
        this.loanRepaymentService = loanRepaymentService;
    }

    @GetMapping
    public List<LoanRepayment> getAllRepayments() {
        return loanRepaymentService.getAllRepayments();
    }

    @GetMapping("/{loanId}")
    public List<LoanRepayment> getRepaymentsByLoanId(@PathVariable Long loanId) {
        return loanRepaymentService.getRepaymentsByLoanId(loanId);
    }

    @PostMapping("/{loanId}")
    public ResponseEntity<LoanRepayment> makeRepayment(@PathVariable Long loanId,
            @RequestBody LoanRepayment repayment) {
        try {
            LoanRepayment savedRepayment = loanRepaymentService.makeRepayment(loanId, repayment);
            return ResponseEntity.ok(savedRepayment);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

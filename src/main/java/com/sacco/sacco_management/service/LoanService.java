package com.sacco.sacco_management.service;

import com.sacco.sacco_management.model.Loan;
import com.sacco.sacco_management.model.Member;
import com.sacco.sacco_management.repository.LoanRepository;
import com.sacco.sacco_management.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    public Loan requestLoan(Long memberId, Loan loanRequest) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (member.isPresent()) {
            loanRequest.setMember(member.get());
            return loanRepository.save(loanRequest);
        } else {
            throw new RuntimeException("Member not found!");
        }
    }

    public Loan approveLoan(Long loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isPresent()) {
            Loan approvedLoan = loan.get();
            approvedLoan.setApproved(true);
            return loanRepository.save(approvedLoan);
        } else {
            throw new RuntimeException("Loan not found!");
        }
    }
}

package com.sacco.sacco_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    private Double amount;
    private Double interestRate;
    private Boolean approved = false;
    private Date loanDate = new Date();
}

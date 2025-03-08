package com.sacco.sacco_management.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class LoanRepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Loan loan;

    private Double amountPaid;
    private Date paymentDate = new Date();
}

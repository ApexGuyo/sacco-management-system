package com.sacco.sacco_management.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private Double savings = 0.0;
}

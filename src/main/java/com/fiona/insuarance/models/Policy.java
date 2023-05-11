package com.fiona.insuarance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="insuranceId")
    private InsurancePolicy insurancePolicy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="policyHolderId")
    private PolicyHolder policyHolder;

    private LocalDate policyStartDate;
    private LocalDate policyEndDate;
    private String policyType;
    private  String policyStatus;
}

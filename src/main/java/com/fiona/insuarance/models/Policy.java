package com.fiona.insuarance.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long policyId;

    @ManyToOne
    @JoinColumn(name="insuranceId")
    private InsurancePolicy insurancePolicyModel;

    @ManyToOne
    @JoinColumn(name="policyHolderId")
    private PolicyHolder policyHolder;
    private Timestamp policyStartDate;
    private Timestamp policyEndDate;
    private String policyType;
    private  String policyStatus;
}

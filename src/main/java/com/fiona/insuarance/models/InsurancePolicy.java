package com.fiona.insuarance.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.websocket.Encoder;
import lombok.Data;
import lombok.Generated;

@Entity
@Data
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long insuranceId;
    private String name;
    private String description;
    private double  coverage_amount;

}

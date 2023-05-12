package com.fiona.insuarance.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quotationId;
    private String premium;
    private String planName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "policyHolderId")
    private PolicyHolder policyHolder;


}

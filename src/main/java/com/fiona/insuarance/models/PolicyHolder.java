package com.fiona.insuarance.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Setter
@Getter
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyHolderId;
    @OneToMany(mappedBy = "policyHolder")
    private List<Policy> policies;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

}

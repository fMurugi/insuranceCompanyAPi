package com.fiona.insuarance.service;

import com.fiona.insuarance.models.InsurancePolicy;
import com.fiona.insuarance.repositories.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {
    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    public List<InsurancePolicy> getALlInsurancePolicies(){
       return  insurancePolicyRepository.findAll();
    }

    public void saveInsurancePolicy(InsurancePolicy insurancePolicy){
        insurancePolicyRepository.save(insurancePolicy);
    }
}

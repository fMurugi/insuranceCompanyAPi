package com.fiona.insuarance.controllers;

import com.fiona.insuarance.models.InsurancePolicy;
import com.fiona.insuarance.service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurancePolicy")
public class InsurancePolicyController {

    @Autowired
    InsurancePolicyService insurancePolicyService;
    @GetMapping("/all")
    public List<InsurancePolicy> getAllPolicies(){
       return insurancePolicyService.getALlInsurancePolicies();
    }
    @PostMapping("/create")
    public void createAPolicy(@RequestBody InsurancePolicy insurancePolicy){
        insurancePolicyService.saveInsurancePolicy(insurancePolicy);
    }

    //policyHolders apply for a policy



}

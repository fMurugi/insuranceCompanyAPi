package com.fiona.insuarance.service;

import com.fiona.insuarance.models.InsurancePolicy;
import com.fiona.insuarance.models.Policy;
import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.models.Quotation;
import com.fiona.insuarance.repositories.InsurancePolicyRepository;
import com.fiona.insuarance.repositories.PolicyHoldersRepository;
import com.fiona.insuarance.repositories.PolicyRepository;
import com.fiona.insuarance.repositories.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private PolicyHoldersRepository policyHoldersRepository;
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    private QuotationRepository quotationRepository;

    public Policy createPolicy (Long policyHolderId, Long insuranceId, Policy policy){
        PolicyHolder policyHolder = policyHoldersRepository.findById(policyHolderId).orElseThrow(() ->
                new IllegalArgumentException("Policy holder not found for id : "+ policyHolderId));

        InsurancePolicy insurancePolicy = insurancePolicyRepository.findById(insuranceId)
                .orElseThrow(() -> new IllegalArgumentException("Insurance policy not found for id: " + insuranceId));

//        Quotation quotation =  quotationRepository.findById(quotationId)
//                .orElseThrow(()-> new IllegalArgumentException("Quotation  not found for id: " + quotationId) );

        LocalDate startDate = LocalDate.now(); // set start date as current date without time
        LocalDate endDate = startDate.plusYears(1); // calculate end date to be one year from start date


        policy.setPolicyHolder(policyHolder);
        policy.setInsurancePolicy(insurancePolicy);
        policy.setPolicyStartDate(startDate);
        policy.setPolicyEndDate(endDate);

     return policyRepository.save(policy);
    }

    //get all policies
    public List<Policy> getAllPolicies(){
       return  policyRepository.findAll();
    }

    //get policy for a policy holder
    public List<Policy> getPoliciesByPolicyHolderId(Long policyHolderId) {
        Optional<PolicyHolder> policyHolderOptional = policyHoldersRepository.findById(policyHolderId);
        if (policyHolderOptional.isPresent()) {
            PolicyHolder policyHolder = policyHolderOptional.get();
            return policyHolder.getPolicies();
        } else {
            return Collections.emptyList();
        }
    }
}

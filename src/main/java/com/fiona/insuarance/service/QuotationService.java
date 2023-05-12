package com.fiona.insuarance.service;

import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.models.Quotation;
import com.fiona.insuarance.repositories.PolicyHoldersRepository;
import com.fiona.insuarance.repositories.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuotationService {
    @Autowired
    QuotationRepository quotationRepository;

    @Autowired
    PolicyHoldersRepository policyHoldersRepository;
    public Quotation generateQuotation(Long policyHolderId){
        Quotation quotation = new Quotation();
        Integer Age = null;
        Boolean ChronicDiseasePresent = null;

        // add a message to reply didnt find the policy holder

        Optional<PolicyHolder> policyHolder = policyHoldersRepository.findById(policyHolderId);

        if(policyHolder.isPresent()){
            Age = policyHolder.get().getAge();
            ChronicDiseasePresent = policyHolder.get().getHasChronicDisease();
            quotation.setPolicyHolder(policyHolder.get());

        }else {

        }

        if(Age<=45 && ChronicDiseasePresent==false){
            quotation.setPremium("ksh 45,000.00");
            quotation.setPlanName("StandardPlan");
        } else if (Age<=45 && ChronicDiseasePresent ==true) {
            quotation.setPremium("ksh 90,000.00");
            quotation.setPlanName("StandardPlan");

        } else if (Age>45 && ChronicDiseasePresent == false) {
            quotation.setPremium("Ksh 100,000.00");
            quotation.setPlanName("StandardPlan");

        } else if (Age>45 && ChronicDiseasePresent == true) {
            quotation.setPremium("Ksh 150,000.00");
            quotation.setPlanName("StandardPlan");
        }
        return quotationRepository.save(quotation);

    }
}

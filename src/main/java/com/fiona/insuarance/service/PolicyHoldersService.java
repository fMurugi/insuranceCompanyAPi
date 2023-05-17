package com.fiona.insuarance.service;

import com.fiona.insuarance.exceptions.PolicyHolderNotFoundException;
import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.repositories.PolicyHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyHoldersService {
    @Autowired
    PolicyHoldersRepository policyHoldersRepository;
    public List<PolicyHolder> getAllPolicyHolders(){
        return policyHoldersRepository.findAll();
    }

    public Optional<PolicyHolder> getOnePolicyHolder(@RequestBody Long policyHolderId){
        Optional<PolicyHolder> policyHolder  = policyHoldersRepository.findById(policyHolderId);
        if(policyHolder.isPresent()){
            return  policyHolder;
        }else {
            throw  new PolicyHolderNotFoundException("PolicyHolder with id " + policyHolderId+" NOT FOUND");
        }
    }

    public void createPolicyHolder(@RequestBody PolicyHolder policyHolder){
        policyHoldersRepository.save(policyHolder);

    }

    public void savePolicyHolder(PolicyHolder policyHolder) {
        policyHoldersRepository.save(policyHolder);
    }
}

package com.fiona.insuarance.controllers;

import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.service.PolicyHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/policyHolders")
public class PolicyHoldersController {
    @Autowired
    PolicyHoldersService policyHoldersService;
    //get all policyHolders

    @GetMapping("/getAllPolicyHolders")
    public List<PolicyHolder> getAllPOlicyHolders(){
       return policyHoldersService.getAllPolicyHolders();
    }

    @PostMapping("/register")
    //create
    public void createOnePolicyHolder( @RequestBody PolicyHolder policyHolder){
         policyHoldersService.createPolicyHolder(policyHolder);
    }

    @GetMapping("/getOnePolicyHolder/{policyHolderId}")
    //getById
    public Optional<PolicyHolder> getOnePOlicyHoldersById(@PathVariable Long policyHolderId){
        return policyHoldersService.getOnePolicyHolder(policyHolderId);
    }

    //edit


}

package com.fiona.insuarance.controllers;

import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.service.PolicyHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PatchMapping("/updatePolicyHolder/{id}")
    public ResponseEntity<PolicyHolder> updatePolicyHolder(@PathVariable Long id, @RequestBody PolicyHolder policyHolderUpdate) {
        Optional<PolicyHolder> optionalPolicyHolder = policyHoldersService.getOnePolicyHolder(id);

        if (optionalPolicyHolder.isPresent()) {
            PolicyHolder policyHolder = optionalPolicyHolder.get();

            // Update the fields of the existing policyHolder with the new values
            if (policyHolderUpdate.getFirstName() != null) {
                policyHolder.setFirstName(policyHolderUpdate.getFirstName());
            }
            if (policyHolderUpdate.getEmail() != null) {
                policyHolder.setEmail(policyHolderUpdate.getEmail());
            }
            if (policyHolderUpdate.getPhoneNumber() != null) {
                policyHolder.setPhoneNumber(policyHolderUpdate.getPhoneNumber());
            }
            if (policyHolderUpdate.getAge() != null) {
                policyHolder.setAge(policyHolderUpdate.getAge());
            }
            if (policyHolderUpdate.getHasChronicDisease() != null) {
                policyHolder.setHasChronicDisease(policyHolderUpdate.getHasChronicDisease());
            }

            // Save the updated policyHolder to the database
            policyHoldersService.savePolicyHolder(policyHolder);

            return new ResponseEntity<>(policyHolder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}

package com.fiona.insuarance.controllers;

import com.fiona.insuarance.models.Policy;
import com.fiona.insuarance.service.PolicyService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping("/{policyHolderId}/{insuranceId}/createPolicy")
    public Policy  createPolicy(@PathVariable Long policyHolderId,@PathVariable Long insuranceId ,@RequestBody Policy policy){
       return policyService.createPolicy(policyHolderId,insuranceId,policy);

//          new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Policy>> getAllPolicies(){
        List<Policy> policies = policyService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }

    //get policies for a certain policyHolder
    @GetMapping("/{policyHolderId}")
    public ResponseEntity<List<Policy>> getPoliciesByPolicyHolderId(@PathVariable Long policyHolderId) {
        List<Policy> policies = policyService.getPoliciesByPolicyHolderId(policyHolderId);
        if (policies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(policies);
    }


}

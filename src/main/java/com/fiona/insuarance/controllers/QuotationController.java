package com.fiona.insuarance.controllers;

import com.fiona.insuarance.models.PolicyHolder;
import com.fiona.insuarance.models.Quotation;
import com.fiona.insuarance.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotation")
public class QuotationController {
    @Autowired
    QuotationService quotationService;

    // generate quotation
    @PostMapping("/{policyHolderId}/generate")
    public Quotation generateQuotation(@PathVariable Long policyHolderId){
       return quotationService.generateQuotation(policyHolderId);
    }
}

package com.fiona.insuarance.repositories;

import com.fiona.insuarance.models.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation,Long> {
}

package com.fiona.insuarance.repositories;

import com.fiona.insuarance.models.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long > {
}

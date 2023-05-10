package com.fiona.insuarance.repositories;

import com.fiona.insuarance.models.PolicyHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyHoldersRepository extends JpaRepository<PolicyHolder,Long> {
}

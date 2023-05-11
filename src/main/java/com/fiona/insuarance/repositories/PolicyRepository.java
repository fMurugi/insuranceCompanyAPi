package com.fiona.insuarance.repositories;

import com.fiona.insuarance.models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy,Long> {
}

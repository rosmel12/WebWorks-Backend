package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.PlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<PlanModel,Integer> {
}

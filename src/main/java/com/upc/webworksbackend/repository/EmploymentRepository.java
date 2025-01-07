package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.EmploymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentRepository extends JpaRepository<EmploymentModel,Integer> {
}

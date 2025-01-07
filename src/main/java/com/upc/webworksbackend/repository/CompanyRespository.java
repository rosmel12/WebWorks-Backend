package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRespository extends JpaRepository<CompanyModel,Integer> {
    CompanyModel findByUsername(String username);
}

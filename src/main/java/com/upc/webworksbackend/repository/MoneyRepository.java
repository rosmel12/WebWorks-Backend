package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.MoneyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyRepository extends JpaRepository<MoneyModel,Integer> {
}

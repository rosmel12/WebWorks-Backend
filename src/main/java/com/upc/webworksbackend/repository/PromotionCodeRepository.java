package com.upc.webworksbackend.repository;

import com.upc.webworksbackend.model.PromotionCodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionCodeRepository extends JpaRepository<PromotionCodeModel, Integer> {
    PromotionCodeModel findByCode(String promotionCode);
}

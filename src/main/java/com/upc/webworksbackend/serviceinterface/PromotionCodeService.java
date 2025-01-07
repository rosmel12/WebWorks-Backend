package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.PromotionCodeDto;
import com.upc.webworksbackend.model.PromotionCodeModel;
import com.upc.webworksbackend.repository.PromotionCodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PromotionCodeService {

    private final PromotionCodeRepository promotionCodeRepository;

    public PromotionCodeService(PromotionCodeRepository promotionCodeRepository) {
        this.promotionCodeRepository = promotionCodeRepository;
    }

    public PromotionCodeDto getPromotionCode(String promotionCode) {
        PromotionCodeModel promotionCodeModel = promotionCodeRepository.findByCode(promotionCode);
        if (promotionCodeModel != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(promotionCodeModel, PromotionCodeDto.class);
        }
        return null;
    }
}

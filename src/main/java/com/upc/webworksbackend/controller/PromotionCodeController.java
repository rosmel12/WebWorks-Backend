package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.PromotionCodeDto;
import com.upc.webworksbackend.serviceinterface.PromotionCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController()
@RequestMapping("/webworks/promotionCode")
@CrossOrigin
public class PromotionCodeController {
    final PromotionCodeService promotionCodeService;

    public PromotionCodeController(PromotionCodeService promotionCodeService) {
        this.promotionCodeService = promotionCodeService;
    }
    @GetMapping("/user/getPromotion/{code}")
    public ResponseEntity<PromotionCodeDto> projectsRepository(@PathVariable String code) {
        return new ResponseEntity<>(promotionCodeService.getPromotionCode(code), HttpStatus.OK);
    }
}

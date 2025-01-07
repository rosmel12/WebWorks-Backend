package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.PlanDto;
import com.upc.webworksbackend.serviceinterface.PlanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webworks/planes")
@CrossOrigin()
public class PlanController {

    final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping()
    public ResponseEntity<List<PlanDto>> listarPlan() {
        return new ResponseEntity<>(planService.ListPlan(), HttpStatus.OK);
    }
}

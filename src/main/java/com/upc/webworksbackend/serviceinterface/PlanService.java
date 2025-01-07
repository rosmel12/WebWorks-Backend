package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.PlanDto;
import com.upc.webworksbackend.model.PlanModel;
import com.upc.webworksbackend.repository.PlanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlanService {

    final private PlanRepository planRepository;
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<PlanDto> ListPlan(){
        List<PlanModel> listPlan = planRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return Arrays.asList(modelMapper.map(listPlan , PlanDto[].class));
    }
}

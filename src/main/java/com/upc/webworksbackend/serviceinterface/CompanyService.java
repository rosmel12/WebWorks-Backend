package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.CompanyDto;
import com.upc.webworksbackend.model.CompanyModel;
import com.upc.webworksbackend.repository.CompanyRespository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private final CompanyRespository companyRespository;

    public CompanyService(CompanyRespository companyRespository) {
        this.companyRespository = companyRespository;
    }

    public CompanyDto addCompany(CompanyDto companyDto) {
        CompanyModel companyModel = companyRespository.findByUsername(companyDto.getUsername());
        if (companyModel == null) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(companyDto.getPassword());
            companyDto.setPassword(encodedPassword);
            ModelMapper modelMapper = new ModelMapper();
            companyModel = modelMapper.map(companyDto, CompanyModel.class);
            companyModel= companyRespository.save(companyModel);
            companyDto = modelMapper.map(companyModel, CompanyDto.class);
            return companyDto;
        }
       return null;
    }

    public CompanyDto companyByUsername(String username) {
        CompanyModel companyModel = companyRespository.findByUsername(username);
        if (companyModel != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(companyModel, CompanyDto.class);
        }
        return null;
    }

    public Boolean updateCompany(CompanyDto companyDto){
        CompanyModel companyModel=companyRespository.findById(companyDto.getId()).orElse(null);
        if(companyModel!=null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(companyDto.getPassword());
            companyModel.setRuc(companyDto.getRuc());
            companyModel.setSocialReason(companyDto.getSocialReason());
            companyModel.setSector(companyDto.getSector());
            companyModel.setLegalRepresentative(companyDto.getLegalRepresentative());
            companyModel.setDescription(companyDto.getDescription());
            companyModel.setUsername(companyDto.getUsername());
            companyModel.setPassword(encodedPassword);
            companyRespository.save(companyModel);
            return true;
        }

        return false;
    }

    public List<CompanyDto> getAllCompany() {
        List <CompanyModel> companyModel = companyRespository.findAll();
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (CompanyModel companyModel1 : companyModel) {
            CompanyDto companyDto = new CompanyDto();
            companyDtos.add(companyDto);
        }
        return companyDtos;
    }

}

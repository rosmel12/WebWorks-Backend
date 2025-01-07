package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.EmploymentDto;
import com.upc.webworksbackend.dto.EmploymentSummaryDto;
import com.upc.webworksbackend.model.CompanyModel;
import com.upc.webworksbackend.model.EmploymentModel;
import com.upc.webworksbackend.repository.CompanyRespository;
import com.upc.webworksbackend.repository.EmploymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmploymentService {

    private final EmploymentRepository employmentRepository;
    private final CompanyRespository companyRespository;

    public EmploymentService(EmploymentRepository employmentRepository, CompanyRespository companyRespository) {
        this.employmentRepository = employmentRepository;
        this.companyRespository = companyRespository;
    }

    public List<EmploymentDto> getEmploymentsByCompany(Integer idCompany){
        List<EmploymentModel> employmentModels=employmentRepository.findAll();
        List<EmploymentDto> employmentDtos=new java.util.ArrayList<>();
        for(EmploymentModel employmentModel:employmentModels){
            if(employmentModel.getCompanyEmployment().getId().equals(idCompany)){
            ModelMapper modelMapper=new ModelMapper();
            EmploymentDto employmentDto=modelMapper.map(employmentModel,EmploymentDto.class);
            employmentDtos.add(employmentDto);
            }
        }
        return employmentDtos;
    }

    public Boolean addEmployment(EmploymentDto employmentDto){
        CompanyModel companyModel=companyRespository.findById(employmentDto.getId_company()).orElse(null);
        if(companyModel!=null){
            ModelMapper modelMapper=new ModelMapper();
            EmploymentModel employmentModel=modelMapper.map(employmentDto,EmploymentModel.class);
            employmentModel.setCompanyEmployment(companyModel);
            employmentRepository.save(employmentModel);
            return true;
        }
        return false;
    }

    public EmploymentDto getEmploymentById(Integer id){
        EmploymentModel employmentModel=employmentRepository.findById(id).orElse(null);
        if(employmentModel!=null){
            ModelMapper modelMapper=new ModelMapper();
            return modelMapper.map(employmentModel,EmploymentDto.class);
        }
        return null;
    }

    public Boolean updateEmployment(EmploymentDto employmentDto){
        EmploymentModel employmentModel=employmentRepository.findById(employmentDto.getId()).orElse(null);
        if(employmentModel!=null){
            employmentModel.setTitle(employmentDto.getTitle());
            employmentModel.setPosition(employmentDto.getPosition());
            employmentModel.setDescription(employmentDto.getDescription());
            employmentModel.setVacancies(employmentDto.getVacancies());
            employmentRepository.save(employmentModel);
            return true;
        }
        return false;
    }

    public Boolean deleteEmployment(Integer id){
        EmploymentModel employmentModel=employmentRepository.findById(id).orElse(null);
        if(employmentModel!=null){
            employmentRepository.delete(employmentModel);
            return true;
        }
        return false;
    }

    public List<EmploymentSummaryDto> getEmploymentsSummary(){
        List<EmploymentModel> employmentModels=employmentRepository.findAll();
        List<EmploymentSummaryDto> employmentSummaryDto=new ArrayList<>();
        for(EmploymentModel employmentModel:employmentModels){
            if(!employmentModel.getDateMaxPostulation().isBefore(LocalDate.now())){
           EmploymentSummaryDto employmentDto=new EmploymentSummaryDto();
           employmentDto.setId(employmentModel.getId());
           employmentDto.setCompanyName(employmentModel.getCompanyEmployment().getSocialReason());
           employmentDto.setTitle(employmentModel.getTitle());
           employmentDto.setPosition(employmentModel.getPosition());
           employmentDto.setDescription(employmentModel.getDescription());
           employmentDto.setVacancies(employmentModel.getVacancies());
           employmentDto.setDateMaxPostulation(employmentModel.getDateMaxPostulation());
           employmentDto.setId_company(employmentModel.getCompanyEmployment().getId());
           employmentSummaryDto.add(employmentDto);
            }
        }
        return employmentSummaryDto;
    }



}

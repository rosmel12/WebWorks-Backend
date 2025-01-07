package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.MethodPaymentDto;
import com.upc.webworksbackend.model.MethodPaymentModel;
import com.upc.webworksbackend.model.MoneyModel;
import com.upc.webworksbackend.model.UserModel;
import com.upc.webworksbackend.repository.MethodPaymentRepository;
import com.upc.webworksbackend.repository.MoneyRepository;
import com.upc.webworksbackend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class MethodPaymentService {
 final MethodPaymentRepository methodPaymentRepository;
 final UserRepository userRepository;
 final MoneyRepository moneyRepository;

 public MethodPaymentService(MethodPaymentRepository methodPaymentRepository, UserRepository userRepository, MoneyRepository moneyRepository) {
        this.methodPaymentRepository = methodPaymentRepository;
        this.userRepository = userRepository;
        this.moneyRepository = moneyRepository;
    }


public Boolean addMethodPayment(MethodPaymentDto methodPaymentDto){
     UserModel personModel= userRepository.findById(methodPaymentDto.getId_user()).orElse(null);
     MoneyModel moneyModel=moneyRepository.findById(methodPaymentDto.getId_money()).orElse(null);
     if(personModel!=null && moneyModel!=null){
      ModelMapper modelMapper = new ModelMapper();
      MethodPaymentModel methodPaymentModel = modelMapper.map(methodPaymentDto, MethodPaymentModel.class);
      methodPaymentModel.setUserMethodPayment(personModel);
      methodPaymentModel.setMoneyMethodPayment(moneyModel);
      methodPaymentRepository.save(methodPaymentModel);
      return true;
     }
     return false;
}

public List<MethodPaymentDto> methodsPaymentByUser(Integer id){
   List<MethodPaymentModel> methodPaymentModels=methodPaymentRepository.findAll();
   List<MethodPaymentDto> methodPaymentDtos=new ArrayList<>();
   for (MethodPaymentModel methodPaymentModel : methodPaymentModels) {
      if(methodPaymentModel.getUserMethodPayment().getId().equals(id)){
      ModelMapper modelMapper = new ModelMapper();
      MethodPaymentDto methodPaymentDto = modelMapper.map(methodPaymentModel, MethodPaymentDto.class);
      methodPaymentDtos.add(methodPaymentDto);
      }
   }
   return methodPaymentDtos;
 }

public MethodPaymentDto methodPaymentById(Integer id){
        MethodPaymentModel methodPaymentModel=methodPaymentRepository.findById(id).orElse(null);
        if(methodPaymentModel!=null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(methodPaymentModel, MethodPaymentDto.class);}
     return null;
}

public Boolean deleteMethodPayment(Integer id){
        MethodPaymentModel methodPaymentModel=methodPaymentRepository.findById(id).orElse(null);
        if(methodPaymentModel!=null){
            methodPaymentRepository.delete(methodPaymentModel);
            return true;
        }
        return false;
}

public Boolean updateMethodPayment(MethodPaymentDto methodPaymentDto){
        MethodPaymentModel methodPaymentModel=methodPaymentRepository.findById(methodPaymentDto.getId()).orElse(null);
        if(methodPaymentModel!=null){
            methodPaymentModel.setNumberCard(methodPaymentDto.getNumberCard());
            methodPaymentModel.setDateCard(methodPaymentDto.getDateCard());
            methodPaymentModel.setCvv(methodPaymentDto.getCvv());
          methodPaymentRepository.save(methodPaymentModel);
          return true;
        }
        return false;
    }
}

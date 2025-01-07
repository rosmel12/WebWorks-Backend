package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.RepositoryDto;
import com.upc.webworksbackend.model.RepositoryModel;
import com.upc.webworksbackend.model.UserModel;
import com.upc.webworksbackend.repository.RepositoryRepository;
import com.upc.webworksbackend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepositoryService {

    private final RepositoryRepository repositoryRepository;
    private final UserRepository userRepository;

    public RepositoryService(RepositoryRepository repositoryRepository, UserRepository userRepository) {
        this.repositoryRepository = repositoryRepository;
        this.userRepository = userRepository;
    }

    public List<RepositoryDto> listRepository() {
        List<RepositoryModel> repositoryModels=repositoryRepository.findAll();
        List<RepositoryDto> repositoryDtos = new ArrayList<>();
        for (RepositoryModel repositoryModel : repositoryModels) {
            RepositoryDto repositoryDto = new RepositoryDto();
           repositoryDtos.add(repositoryDto);
        }
        return repositoryDtos;
   }

    public Boolean addRepository(RepositoryDto repositoryDto) {
        UserModel userModel=userRepository.findById(repositoryDto.getId_user()).orElse(null);
        if(userModel!=null){
            ModelMapper modelMapper = new ModelMapper();
            RepositoryModel repositoryModel = modelMapper.map(repositoryDto, RepositoryModel.class);
            repositoryModel.setUserRepository(userModel);
            repositoryRepository.save(repositoryModel);
            return true;
        }
        return false;
    }

    public RepositoryDto repositoryById(Integer id) {
        List<RepositoryModel> repositoryModels=repositoryRepository.findAll();
        for (RepositoryModel repositoryModel : repositoryModels) {
            if (repositoryModel.getId().equals(id)) {
                ModelMapper modelMapper = new ModelMapper();
                return modelMapper.map(repositoryModel, RepositoryDto.class);
            }
        }
     return null;
    }

    public List<RepositoryDto> repositoryByUser(Integer id) {
        List<RepositoryModel> repositoryModels=repositoryRepository.findAll();
        List<RepositoryDto> repositoryDtos = new ArrayList<>();
        for (RepositoryModel repositoryModel : repositoryModels) {
            ModelMapper modelMapper = new ModelMapper();
            if (repositoryModel.getUserRepository().getId().equals(id)) {
                RepositoryDto repositoryDto = modelMapper.map(repositoryModel, RepositoryDto.class);
                repositoryDtos.add(repositoryDto);
            }
        }
        return repositoryDtos;
    }

    public Boolean updateRepository(RepositoryDto repositoryDto) {
        RepositoryModel repositoryModel = repositoryRepository.findById(repositoryDto.getId()).orElse(null);
        if (repositoryModel != null) {
            repositoryModel.setName(repositoryDto.getName());
            repositoryModel.setDescription(repositoryDto.getDescription());
            repositoryModel.setNumberProject(repositoryDto.getNumberProject());
           repositoryRepository.save(repositoryModel);
           return true;
        }
       return false;
    }

    public Boolean deleteRepository(Integer id) {
        RepositoryModel repositoryModel = repositoryRepository.findById(id).orElse(null);
        if (repositoryModel != null) {
            repositoryRepository.delete(repositoryModel);
            return true;
        }
        return false;
    }
}

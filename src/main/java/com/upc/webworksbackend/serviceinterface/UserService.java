package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.UserDto;
import com.upc.webworksbackend.model.UserModel;
import com.upc.webworksbackend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto addUser(UserDto userDto) {
        UserModel userModel =userRepository.findByUsername(userDto.getUsername());
        if(userModel==null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            userDto.setPassword(encodedPassword);
            ModelMapper modelMapper = new ModelMapper();
            userModel = modelMapper.map(userDto, UserModel.class);
            userModel=userRepository.save(userModel);
            userDto=modelMapper.map(userModel, UserDto.class);
            return userDto;
        }else {
            return null;
        }
    }

    public UserDto userByUsername(String  username){
        UserModel user = userRepository.findByUsername(username);
        if (user !=null){
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(user, UserDto.class);
        }
        return null;
    }

    public Boolean updateUser(UserDto userDto){
        UserModel userModel=userRepository.findById(userDto.getId()).orElse(null);
        if(userModel!=null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            userModel.setUsername(userDto.getUsername());
            userModel.setLastname(userDto.getLastname());
            userModel.setBirthDate(userDto.getBirthDate());
            userModel.setPhone(userDto.getPhone());
            userModel.setEmail(userDto.getEmail());
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(encodedPassword);
            userModel.setPhoto(userDto.getPhoto());
            userRepository.save(userModel);
            return true;
        }
        return false;
    }

    public Boolean deleteUser(Integer id){
        UserModel userModel = userRepository.findById(id).orElse(null);
        if (userModel != null) {
            userRepository.delete(userModel);
            return true;
        }
        return false;
    }

    public UserDto getUserById(Integer id){
        UserModel userModel = userRepository.findById(id).orElse(null);
        if (userModel != null) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(userModel, UserDto.class);
        }
        return null;
    }

    public List<UserDto> getAllUsers(){
        List<UserModel> userModels = userRepository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return Arrays.asList(modelMapper.map(userModels, UserDto[].class));
    }


}

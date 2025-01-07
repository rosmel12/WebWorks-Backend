package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.UserDto;
import com.upc.webworksbackend.serviceinterface.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webworks/usuario")
@CrossOrigin()
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /// User
    @GetMapping("/user/userByUsername/{username}")
    public ResponseEntity<UserDto> userByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userService.userByUsername(username), HttpStatus.OK);
    }

    @PutMapping("/user/updateUser")
    public ResponseEntity<Boolean> updateUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.updateUser(userDto),HttpStatus.OK);
    }

    @GetMapping("/user/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }


    /// Company
    @GetMapping("/company/userById/{idUser}")
    public ResponseEntity<UserDto> userById(@PathVariable Integer idUser) {
        return new ResponseEntity<>(userService.getUserById(idUser), HttpStatus.OK);
    }


}

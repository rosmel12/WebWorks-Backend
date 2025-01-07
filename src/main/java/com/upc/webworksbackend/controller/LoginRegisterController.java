package com.upc.webworksbackend.controller;


import com.upc.webworksbackend.dto.CompanyDto;
import com.upc.webworksbackend.dto.UserDto;
import com.upc.webworksbackend.dto.UserLoginDto;
import com.upc.webworksbackend.security.JwtResponse;
import com.upc.webworksbackend.security.JwtTokenUtil;
import com.upc.webworksbackend.serviceimplements.JwtUserDetailsService;
import com.upc.webworksbackend.serviceinterface.CompanyService;
import com.upc.webworksbackend.serviceinterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webworks")
@CrossOrigin
public class LoginRegisterController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("/registerUser")
    public ResponseEntity<UserDto> agregarUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.CREATED);
    }
    @PostMapping("/registerCompany")
    public ResponseEntity<CompanyDto> agregarCompany(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.addCompany(companyDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticateUser(@RequestBody UserLoginDto user) throws Exception {
        authenticateUser(user.getUsername(), user.getPassword());
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticateUser(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch(DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }catch(BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }
}

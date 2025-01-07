package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.CompanyDto;
import com.upc.webworksbackend.serviceinterface.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/webworks/corporation")
@CrossOrigin
public class CompanyController {
    final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/List")
    public ResponseEntity<List<CompanyDto>> ListarCompany() {
        return new ResponseEntity<>(companyService.getAllCompany(),HttpStatus.OK);
    }
    @GetMapping("/company/companyByUsername/{username}")
    public ResponseEntity<CompanyDto> companyByUsername(@PathVariable String username) {
        return new ResponseEntity<>(companyService.companyByUsername(username), HttpStatus.OK);
    }
    @PutMapping("/company/updateCompany")
    public ResponseEntity<Boolean> updateCompany(@RequestBody CompanyDto companyDto) {
        return new ResponseEntity<>(companyService.updateCompany(companyDto),HttpStatus.OK);
    }

}

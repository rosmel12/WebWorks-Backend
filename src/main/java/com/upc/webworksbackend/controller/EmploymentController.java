package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.EmploymentDto;
import com.upc.webworksbackend.dtoaux.EmploymentSummaryDto;
import com.upc.webworksbackend.serviceinterface.EmploymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/webworks/employment")
@CrossOrigin
public class EmploymentController {
    private final EmploymentService employmentService;

    public EmploymentController(EmploymentService employmentService) {
        this.employmentService = employmentService;
    }

    @GetMapping("/company/getEmploymentsByCompany/{idCompany}")
    public ResponseEntity<List<EmploymentDto>> getEmploymentsByCompany(@PathVariable Integer idCompany){
        return new ResponseEntity<>(employmentService.getEmploymentsByCompany(idCompany), HttpStatus.OK);
    }

    @PostMapping("/company/addEmployment")
    public ResponseEntity<Boolean> addEmployment(@RequestBody EmploymentDto employmentDto){
        return new ResponseEntity<>(employmentService.addEmployment(employmentDto), HttpStatus.CREATED);
    }
    @GetMapping("/company/getEmploymentById/{id}")
    public ResponseEntity<EmploymentDto> getEmploymentById(@PathVariable Integer id){
        return new ResponseEntity<>(employmentService.getEmploymentById(id), HttpStatus.OK);
    }

    @PutMapping("/company/updateEmployment")
    public ResponseEntity<Boolean> updateEmployment(@RequestBody EmploymentDto employmentDto){
        return new ResponseEntity<>(employmentService.updateEmployment(employmentDto), HttpStatus.OK);
    }
    @DeleteMapping("/company/deleteEmployment/{id}")
    public ResponseEntity<Boolean> deleteEmployment(@PathVariable Integer id){
        return new ResponseEntity<>(employmentService.deleteEmployment(id), HttpStatus.OK);
    }

    @GetMapping("/user/getEmploymentsSummary")
    public ResponseEntity<List<EmploymentSummaryDto>> getEmploymentsSummary(){
        return new ResponseEntity<>(employmentService.getEmploymentsSummary(), HttpStatus.OK);
    }


}

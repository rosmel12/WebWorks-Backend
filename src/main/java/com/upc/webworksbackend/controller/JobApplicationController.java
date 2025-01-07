package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.JobApplicationDto;
import com.upc.webworksbackend.dto.JobApplicationSummaryDto;
import com.upc.webworksbackend.serviceinterface.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/webworks/jobApplication")
@CrossOrigin
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/user/addJobApplication")
    public ResponseEntity<Boolean> addJobApplication(@RequestBody JobApplicationDto jobApplicationDto){
        return new ResponseEntity<>(jobApplicationService.addJobApplication(jobApplicationDto),HttpStatus.CREATED);
    }

    @GetMapping("/user/checkJobApplication/{idEmployment}/{idUser}")
    public ResponseEntity<Boolean> checkJobApplication(@PathVariable Integer idEmployment,@PathVariable Integer idUser){
        return new ResponseEntity<>(jobApplicationService.checkJobApplication(idEmployment,idUser),HttpStatus.OK);
    }

    @GetMapping("/company/getJobApplicationStatusByCompany/{idCompany}/{status}")
    public ResponseEntity<List<JobApplicationSummaryDto>> getJobApplicationStatusByCompany(@PathVariable Integer idCompany , @PathVariable String status){
        return new ResponseEntity<>(jobApplicationService.getJobApplicationStatusByCompany(idCompany,status),HttpStatus.OK);
    }



    @GetMapping("/company/changeJobApplication/{idJobApplication}/{status}")
    public ResponseEntity<Boolean> changeJobApplication(@PathVariable Integer idJobApplication, @PathVariable String status){
        return  new ResponseEntity<>(jobApplicationService.changeJobApplication(idJobApplication,status),HttpStatus.OK);
    }



}

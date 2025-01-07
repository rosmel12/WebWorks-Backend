package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.SystemScoreDto;
import com.upc.webworksbackend.serviceinterface.SystemScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webworks/systemScore")
@CrossOrigin
public class SystemScoreController {

    final SystemScoreService systemScoreService;

    public SystemScoreController(SystemScoreService systemScoreService) {
        this.systemScoreService = systemScoreService;
    }
    @PostMapping("/user/addScore")
    public ResponseEntity<Boolean> addScore(@RequestBody SystemScoreDto systemScoreDto) {
        return new ResponseEntity<>(systemScoreService.addSystemScore(systemScoreDto), HttpStatus.CREATED);
    }


}

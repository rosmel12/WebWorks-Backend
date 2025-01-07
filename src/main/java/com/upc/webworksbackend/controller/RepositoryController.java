package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.RepositoryDto;
import com.upc.webworksbackend.serviceinterface.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webworks/repository")
@CrossOrigin
public class RepositoryController {

    final RepositoryService repositoryService;

    public RepositoryController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    ///USER
    @PostMapping("/user/addRepository")
    public ResponseEntity<Boolean> addRepository(@RequestBody RepositoryDto repositoryDto) {
        return new ResponseEntity<>(repositoryService.addRepository(repositoryDto), HttpStatus.CREATED);
    }
    @GetMapping("/user/repositoryByUser/{id}")
    public ResponseEntity<List<RepositoryDto>> repositoryByUser(@PathVariable Integer id) {
        return new ResponseEntity<>(repositoryService.repositoryByUser(id),HttpStatus.OK);
    }

    @GetMapping("/user/repositoryById/{id}")
    public ResponseEntity<RepositoryDto> repositoryById(@PathVariable Integer id) {
        return new ResponseEntity<>(repositoryService.repositoryById(id),HttpStatus.OK);
    }

    @GetMapping({"/normal/listRepository","/developer/listRepository"})
    public ResponseEntity<List<RepositoryDto>> findAll() {
        return new ResponseEntity<>(repositoryService.listRepository(),HttpStatus.OK);
    }

    @PutMapping("/user/updateRepository")
    public ResponseEntity<Boolean> updateRepository(@RequestBody RepositoryDto repositoryDto) {
        return new ResponseEntity<>(repositoryService.updateRepository(repositoryDto),HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteRepository/{id}")
    public ResponseEntity<Boolean> deleteRepository(@PathVariable Integer id){
        return new ResponseEntity<>(repositoryService.deleteRepository(id),HttpStatus.OK);
    }

    ///Company
    @GetMapping("/company/repositoryByUserCompany/{idUser}")
    public ResponseEntity<List<RepositoryDto>> repositoryByUserCompany(@PathVariable Integer idUser) {
        return new ResponseEntity<>(repositoryService.repositoryByUser(idUser),HttpStatus.OK);
    }
}


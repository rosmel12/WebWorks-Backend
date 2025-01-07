package com.upc.webworksbackend.controller;

import com.upc.webworksbackend.dto.ProjectDbo;
import com.upc.webworksbackend.serviceinterface.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/webworks/project")
@CrossOrigin
public class ProjectController {
    final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/user/addProject")
    public ResponseEntity<Boolean> agregarProyecto(@RequestBody ProjectDbo projectDbo) {
        return new ResponseEntity<>(projectService.addProject(projectDbo),HttpStatus.CREATED);
    }

    @GetMapping("/user/projectsRepository/{id}")
    public ResponseEntity<List<ProjectDbo>> projectsRepository(@PathVariable Integer id) {
        return new ResponseEntity<>(projectService.projectsByRepository(id),HttpStatus.OK);
    }

    @GetMapping("/user/projectById/{id}")
    public ResponseEntity<ProjectDbo> projectById(@PathVariable Integer id) {
        return new ResponseEntity<>(projectService.projectById(id),HttpStatus.OK);
    }

    @PutMapping("/user/updateProject")
    public ResponseEntity<Boolean> updateProject(@RequestBody ProjectDbo projectDbo) {
        return new ResponseEntity<>(projectService.updateProject(projectDbo),HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteProject/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Integer id) {
        return new ResponseEntity<>(projectService.deleteProject(id),HttpStatus.OK);
    }

    /// Company
    @GetMapping("/company/projectsRepository/{idRepository}")
    public ResponseEntity<List<ProjectDbo>> projectsRepositoryCompany(@PathVariable Integer idRepository) {
        return new ResponseEntity<>(projectService.projectsByRepository(idRepository),HttpStatus.OK);
    }

}

package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.ProjectDbo;
import com.upc.webworksbackend.model.ProjectModel;
import com.upc.webworksbackend.model.RepositoryModel;
import com.upc.webworksbackend.repository.RepositoryRepository;

import com.upc.webworksbackend.repository.ProjectRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    final ProjectRepository projectRepository;
    final RepositoryRepository repositoryRepository;

    public ProjectService(ProjectRepository projectRepository, RepositoryRepository repositoryRepository) {
        this.projectRepository = projectRepository;
        this.repositoryRepository = repositoryRepository;
    }

    public Boolean addProject(ProjectDbo projectDbo){
        RepositoryModel repositoryModel = repositoryRepository.findById(projectDbo.getId_repository()).orElse(null);
        List<ProjectDbo> projects= projectsByRepository(projectDbo.getId());
       if(repositoryModel!=null&& projects.size()<repositoryModel.getNumberProject()){
           ModelMapper modelMapper = new ModelMapper();
           ProjectModel projectModel = modelMapper.map(projectDbo, ProjectModel.class);
           projectModel.setRepositoryProject(repositoryModel);
           projectRepository.save(projectModel);
           return true;
       }
        return false;
    }

    public List<ProjectDbo> findAll() {
        List<ProjectModel> projectModels = projectRepository.findAll();
        List<ProjectDbo> projectDbos = new ArrayList<>();
        for (ProjectModel projectModel : projectModels) {
            ProjectDbo projectDbo = new ProjectDbo();
            projectDbos.add(projectDbo);
        }
        return projectDbos;
    }

    public List<ProjectDbo> projectsByRepository(Integer id) {
        List<ProjectModel> projectModels = projectRepository.findAll();
        List<ProjectDbo> projectDbos = new ArrayList<>();
        for (ProjectModel projectModel : projectModels) {
           if (projectModel.getRepositoryProject().getId().equals(id)) {
               ModelMapper modelMapper = new ModelMapper();
               ProjectDbo projectDbo = modelMapper.map(projectModel, ProjectDbo.class);
               projectDbos.add(projectDbo);
           }
        }
        return projectDbos;
    }

    public ProjectDbo projectById(Integer id) {
        ProjectModel project = projectRepository.findById(id).orElse(null);
        if (project != null) {
            ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(project, ProjectDbo.class); }
      return null;
    }

    public Boolean updateProject(ProjectDbo projectDbo){
        ProjectModel projectModel=projectRepository.findById(projectDbo.getId()).orElse(null);
        if(projectModel!=null){
            projectModel.setName(projectDbo.getName());
            projectModel.setDescription(projectDbo.getDescription());
            projectModel.setLanguage(projectDbo.getLanguage());
            projectRepository.save(projectModel);
            return true ;
        }
        return false;
    }


    public Boolean deleteProject(Integer id) {
        ProjectModel projectModel=projectRepository.findById(id).orElse(null);
        if(projectModel!=null){
            projectRepository.delete(projectModel);
            return true;
        }
        return false;
    }
}

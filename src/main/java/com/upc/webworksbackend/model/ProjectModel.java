package com.upc.webworksbackend.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "project")
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dateCreate", nullable = false)
    private Date dateCreate;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "language", nullable = false)
    private String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public RepositoryModel getRepositoryProject() {
        return repositoryProject;
    }

    public void setRepositoryProject(RepositoryModel repositoryProject) {
        this.repositoryProject = repositoryProject;
    }

    ///relation-Repository
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_repository")
    private RepositoryModel repositoryProject;

}

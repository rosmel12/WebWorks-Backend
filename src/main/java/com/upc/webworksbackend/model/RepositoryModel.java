package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "repository")
public class RepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "dateCreate", nullable = false)
    private Date dateCreate;

    @Column(name = "numberProject", nullable = false)
    private int numberProject;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getNumberProject() {
        return numberProject;
    }

    public void setNumberProject(int numberProject) {
        this.numberProject = numberProject;
    }

    public UserModel getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserModel userRepository) {
        this.userRepository = userRepository;
    }

    /// relation-User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userRepository;

    ///relation-Project
    @OneToMany(mappedBy = "repositoryProject",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProjectModel> projects;
}

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
@Table(name = "jobapplication")
public class JobApplicationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "dateApplication", nullable = false)
    private Date dateApplication;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateApplication() {
        return dateApplication;
    }

    public void setDateApplication(Date dateApplication) {
        this.dateApplication = dateApplication;
    }

    public UserModel getUserJobApplication() {
        return userJobApplication;
    }

    public void setUserJobApplication(UserModel userJobApplication) {
        this.userJobApplication = userJobApplication;
    }

    public EmploymentModel getEmploymentJobApplication() {
        return employmentJobApplication;
    }

    public void setEmploymentJobApplication(EmploymentModel employmentJobApplication) {
        this.employmentJobApplication = employmentJobApplication;
    }

    ///relation-Employment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_employment")
    private EmploymentModel employmentJobApplication;

    ///relation-User
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userJobApplication;
}

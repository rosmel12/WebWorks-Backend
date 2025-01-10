package com.upc.webworksbackend.dtoaux;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationSummaryDto {
    private Integer id;
    private String status;
    private Date dateApplication;
    private String namePostulation;
    private String nameEmployment;
    private String positionEmployment;
    private Integer id_employment;
    private Integer id_user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePostulation() {
        return namePostulation;
    }

    public void setNamePostulation(String namePostulation) {
        this.namePostulation = namePostulation;
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

    public void setNameEmployment(String nameEmployment) {
        this.nameEmployment = nameEmployment;
    }

    public String getPositionEmployment() {
        return positionEmployment;
    }

    public void setPositionEmployment(String positionEmployment) {
        this.positionEmployment = positionEmployment;
    }

    public Integer getId_employment() {
        return id_employment;
    }

    public void setId_employment(Integer id_employment) {
        this.id_employment = id_employment;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}

package com.upc.webworksbackend.dtoaux;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentSummaryDto {
    private Integer id;
    private String companyName;
    private String title;
    private String position;
    private String description;
    private int vacancies;
    private LocalDate dateMaxPostulation;
    private Integer id_company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_company() {
        return id_company;
    }

    public void setId_company(Integer id_company) {
        this.id_company = id_company;
    }

    public LocalDate getDateMaxPostulation() {
        return dateMaxPostulation;
    }

    public void setDateMaxPostulation(LocalDate dateMaxPostulation) {
        this.dateMaxPostulation = dateMaxPostulation;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

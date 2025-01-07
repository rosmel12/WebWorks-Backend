package com.upc.webworksbackend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentDto {
    private Integer id;
    private String title;
    private String position;
    private String description;
    private int vacancies;
    private int contracted;
    private LocalDate dateMaxPostulation;
    private Integer id_company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVacancies() {
        return vacancies;
    }

    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }

    public int getContracted() {
        return contracted;
    }

    public void setContracted(int contracted) {
        this.contracted = contracted;
    }

    public LocalDate getDateMaxPostulation() {
        return dateMaxPostulation;
    }

    public void setDateMaxPostulation(LocalDate dateMaxPostulation) {
        this.dateMaxPostulation = dateMaxPostulation;
    }

    public Integer getId_company() {
        return id_company;
    }

    public void setId_company(Integer id_company) {
        this.id_company = id_company;
    }
}

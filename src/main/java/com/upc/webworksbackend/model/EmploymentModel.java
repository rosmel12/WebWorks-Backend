package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "employment")
public class EmploymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "vacancies", nullable = false)
    private int vacancies;

    @Column(name = "contracted", nullable = false)
    private int contracted;

    @Column(name = "dateMaxPostulation", nullable = false)
    private LocalDate dateMaxPostulation;

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

    public CompanyModel getCompanyEmployment() {
        return companyEmployment;
    }

    public void setCompanyEmployment(CompanyModel companyEmployment) {
        this.companyEmployment = companyEmployment;
    }

    ///relation-Company
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_company")
    private CompanyModel companyEmployment;

    ///relation-JobApplication
    @OneToMany(mappedBy = "employmentJobApplication",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<JobApplicationModel> applications;
}

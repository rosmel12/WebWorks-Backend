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
}

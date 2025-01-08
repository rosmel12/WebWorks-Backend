package com.upc.webworksbackend.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanDto {
    private Integer id;
    private String name;
    private String description1;
    private String description2;
    private String description3;
    private String description4;
    private String description5;
    private String description6;
    private String description7;
    private String description8;
    private String description9;
    private String description10;
    private int maxNumberRepository;
    private int maxNumberProject;
    private Float price;
    private String image;
    private Integer id_money;

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

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getDescription5() {
        return description5;
    }

    public void setDescription5(String description5) {
        this.description5 = description5;
    }

    public String getDescription7() {
        return description7;
    }

    public void setDescription7(String description7) {
        this.description7 = description7;
    }

    public String getDescription6() {
        return description6;
    }

    public void setDescription6(String description6) {
        this.description6 = description6;
    }

    public String getDescription8() {
        return description8;
    }

    public void setDescription8(String description8) {
        this.description8 = description8;
    }

    public String getDescription9() {
        return description9;
    }

    public void setDescription9(String description9) {
        this.description9 = description9;
    }

    public String getDescription10() {
        return description10;
    }

    public void setDescription10(String description10) {
        this.description10 = description10;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId_money() {
        return id_money;
    }

    public void setId_money(Integer id_money) {
        this.id_money = id_money;
    }
}

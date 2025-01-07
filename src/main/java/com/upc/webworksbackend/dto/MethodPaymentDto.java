package com.upc.webworksbackend.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MethodPaymentDto {
    private Integer id;
    private String numberCard;
    private Date dateCard;
    private int cvv;
    private Integer id_user;
    private Integer id_money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_money() {
        return id_money;
    }

    public void setId_money(Integer id_money) {
        this.id_money = id_money;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Date getDateCard() {
        return dateCard;
    }

    public void setDateCard(Date dateCard) {
        this.dateCard = dateCard;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }
}

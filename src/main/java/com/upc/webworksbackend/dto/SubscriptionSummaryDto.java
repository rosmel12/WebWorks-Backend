package com.upc.webworksbackend.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionSummaryDto {
    private Date dateStart;
    private Date dateEnd;
    private Float amountTotal;
    private String namePlan;
    private String numberMethodPayment;
    private String namePromotionCode;
    private Double discountPercentage;

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getNamePromotionCode() {
        return namePromotionCode;
    }

    public void setNamePromotionCode(String namePromotionCode) {
        this.namePromotionCode = namePromotionCode;
    }

    public String getNumberMethodPayment() {
        return numberMethodPayment;
    }

    public void setNumberMethodPayment(String numberMethodPayment) {
        this.numberMethodPayment = numberMethodPayment;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

    public Float getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Float amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
}

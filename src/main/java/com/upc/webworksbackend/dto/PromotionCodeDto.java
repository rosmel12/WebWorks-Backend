package com.upc.webworksbackend.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionCodeDto {
    private Integer id;
    private String code;
    private double discountPercentage;
    private double minPurchaseAmount;
    private double maxPurchaseAmount;
    private int maxUsageCount;
    private Date dateStart;
    private Date dateEnd;
    private String status;

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

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public int getMaxUsageCount() {
        return maxUsageCount;
    }

    public void setMaxUsageCount(int maxUsageCount) {
        this.maxUsageCount = maxUsageCount;
    }

    public double getMaxPurchaseAmount() {
        return maxPurchaseAmount;
    }

    public void setMaxPurchaseAmount(double maxPurchaseAmount) {
        this.maxPurchaseAmount = maxPurchaseAmount;
    }

    public double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMinPurchaseAmount(double minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

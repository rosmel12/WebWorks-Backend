package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "promotioncode")
public class PromotionCodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "discountPercentage", nullable = false)
    private double discountPercentage;

    @Column(name = "minPurchaseAmount", nullable = false)
    private double minPurchaseAmount;

    @Column(name = "maxPurchaseAmount", nullable = false)
    private double maxPurchaseAmount;

    @Column(name = "maxUsageCount", nullable = false)
    private int maxUsageCount;

    @Column(name = "dateStart", nullable = false)
    private Date dateStart;

    @Column(name = "dateEnd", nullable = false)
    private Date dateEnd;

    @Column(name = "status", nullable = false)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getMinPurchaseAmount() {
        return minPurchaseAmount;
    }

    public void setMinPurchaseAmount(double minPurchaseAmount) {
        this.minPurchaseAmount = minPurchaseAmount;
    }

    public double getMaxPurchaseAmount() {
        return maxPurchaseAmount;
    }

    public void setMaxPurchaseAmount(double maxPurchaseAmount) {
        this.maxPurchaseAmount = maxPurchaseAmount;
    }

    public int getMaxUsageCount() {
        return maxUsageCount;
    }

    public void setMaxUsageCount(int maxUsageCount) {
        this.maxUsageCount = maxUsageCount;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /// Relation-Subscription
    @OneToMany(mappedBy = "subscriptionPromotionCode",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SubscriptionModel> subscriptions;
}

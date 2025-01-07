package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "subscription")
public class SubscriptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dateStart", nullable = false)
    private Date dateStart;

    @Column(name = "dateEnd", nullable = false)
    private Date dateEnd;

    @Column(name = "amountTotal", nullable = false)
    private Float amountTotal;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(Float amountTotal) {
        this.amountTotal = amountTotal;
    }

    public PlanModel getPlanSubscription() {
        return planSubscription;
    }

    public void setPlanSubscription(PlanModel planSubscription) {
        this.planSubscription = planSubscription;
    }

    public UserModel getUserSubscription() {
        return userSubscription;
    }

    public void setUserSubscription(UserModel userSubscription) {
        this.userSubscription = userSubscription;
    }

    public MethodPaymentModel getMethodPaymentSubscription() {
        return methodPaymentSubscription;
    }

    public void setMethodPaymentSubscription(MethodPaymentModel methodPaymentSubscription) {
        this.methodPaymentSubscription = methodPaymentSubscription;
    }

    public PromotionCodeModel getSubscriptionPromotionCode() {
        return subscriptionPromotionCode;
    }

    public void setSubscriptionPromotionCode(PromotionCodeModel subscriptionPromotionCode) {
        this.subscriptionPromotionCode = subscriptionPromotionCode;
    }

    ///relation-user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userSubscription;

    ///relation-plan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_plan")
    private PlanModel planSubscription;

    ///relation-methodPayment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_methodpayment")
    private MethodPaymentModel methodPaymentSubscription;

    ///relation-promotionCode
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_promotioncode")
    private PromotionCodeModel subscriptionPromotionCode;

}

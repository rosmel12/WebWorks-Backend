package com.upc.webworksbackend.dto;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDbo {
    private Integer id;
    private Date dateStart;
    private Date dateEnd;
    private Float amountTotal;
    private Integer id_user;
    private Integer id_plan;
    private Integer id_methodPayment;
    private Integer id_promotionCode;

    public Integer getId_methodPayment() {
        return id_methodPayment;
    }

    public void setId_methodPayment(Integer id_methodPayment) {
        this.id_methodPayment = id_methodPayment;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public Integer getId_plan() {
        return id_plan;
    }

    public void setId_plan(Integer id_plan) {
        this.id_plan = id_plan;
    }

    public Integer getId_promotionCode() {
        return id_promotionCode;
    }

    public void setId_promotionCode(Integer id_promotionCode) {
        this.id_promotionCode = id_promotionCode;
    }
}

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
@Table(name = "methodpayment")
public class MethodPaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numberCard", nullable = false)
    private String numberCard;

    @Column(name = "dateCard", nullable = false)
    private Date dateCard;

    @Column(name = "cvv", nullable = false)
    private int cvv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCard() {
        return dateCard;
    }

    public void setDateCard(Date dateCard) {
        this.dateCard = dateCard;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public UserModel getUserMethodPayment() {
        return userMethodPayment;
    }

    public void setUserMethodPayment(UserModel userMethodPayment) {
        this.userMethodPayment = userMethodPayment;
    }

    public MoneyModel getMoneyMethodPayment() {
        return moneyMethodPayment;
    }

    public void setMoneyMethodPayment(MoneyModel moneyMethodPayment) {
        this.moneyMethodPayment = moneyMethodPayment;
    }

    ///relation_user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private UserModel userMethodPayment;

    ///relation_money
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_money")
    private MoneyModel moneyMethodPayment;

    /// Relation-subscription
    @OneToMany(mappedBy = "methodPaymentSubscription",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SubscriptionModel> subscriptions;

}

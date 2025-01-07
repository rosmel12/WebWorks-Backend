package com.upc.webworksbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name = "money")
public class MoneyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

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

    /// Relation-Plan
    @OneToMany(mappedBy = "moneyPlan",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PlanModel> plans;

    /// Relation-MethodPayment
    @OneToMany(mappedBy = "moneyMethodPayment",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MethodPaymentModel> methodPayments;
}

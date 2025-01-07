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
@Table(name = "plan")
public class PlanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description1")
    private String description1;

    @Column(name = "description2")
    private String description2;

    @Column(name = "description3")
    private String description3;

    @Column(name = "description4")
    private String description4;

    @Column(name = "description5")
    private String description5;

    @Column(name = "description6")
    private String description6;

    @Column(name = "description7")
    private String description7;

    @Column(name = "description8")
    private String description8;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Column(name = "imagen")
    private String imagen;

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

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription4() {
        return description4;
    }

    public void setDescription4(String description4) {
        this.description4 = description4;
    }

    public String getDescription6() {
        return description6;
    }

    public void setDescription6(String description6) {
        this.description6 = description6;
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

    public String getDescription8() {
        return description8;
    }

    public void setDescription8(String description8) {
        this.description8 = description8;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    ///relation-subscription
    @OneToMany(mappedBy = "planSubscription",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<SubscriptionModel> subscriptionModels;

    ///relation-money
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_money")
    private MoneyModel moneyPlan;

}

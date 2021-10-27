package com.usingjwttokens.example.tokenbased.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Component
@Entity
@Table(name="Orderbe")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "orderId")
    private Long orderId;
    private  String brand;
    private  String funding;
    private   String id;
    private int last4;
    private  String name;
    private  String object;
    private LocalDateTime billingDate;
    private double price;

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
    private Set<Paymentcarts> paycartS =new HashSet<>();

    @OneToOne
    @JoinColumn(name = "shippingid", referencedColumnName = "shippingid")
    private UserShipping userShipping;

    public Order() {

    }

    public UserShipping getUserShipping() {
        return userShipping;
    }

    public void setUserShipping(UserShipping userShipping) {
        this.userShipping = userShipping;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(LocalDateTime billingDate) {
        this.billingDate = billingDate;
    }
    @JsonManagedReference
    public Set<Paymentcarts> getPaycartS() {
        return paycartS;
    }

    public void setPaycartS(Set<Paymentcarts> paycartS) {
        this.paycartS = paycartS;
        for(Paymentcarts c: paycartS)
        {
            c.setOrder(this);
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLast4() {
        return last4;
    }

    public void setLast4(int last4) {
        this.last4 = last4;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
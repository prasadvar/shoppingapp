package com.usingjwttokens.example.tokenbased.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
@Entity
public class Paymentcarts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cartid")
    private Long cartid;

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private  Product product;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
    private  int quantity;
    private double total;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "orderId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Order orders;

    public Paymentcarts() {
    }

    public Paymentcarts(Long cartid, Product product, User user, int quantity, double total, Order orders) {
        this.cartid = cartid;
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.total = total;
        this.orders = orders;
    }

    public Long getCartsid() {
        return cartid;
    }

    public void setCartsid(Long cartsid) {
        this.cartid = cartsid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @JsonBackReference
    public Order getOrder() {
        return orders;
    }

    public void setOrder(Order orders) {
        this.orders = orders;
    }
}

package com.usingjwttokens.example.tokenbased.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "cartbe")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartid;
    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
     private  Product product;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
    private  int quantity;
    private double total;
    public Cart() {
    }
    public Cart(Product product, User user, int quantity, double total) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
        this.total = total;
    }
    public Long getCartid() {
        return cartid;
    }
    public void setCartid(Long cartid) {
        this.cartid = cartid;
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
}

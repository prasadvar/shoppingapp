package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;

@Entity
public class Transactionmang {

    @Id
    private  Long orderId;
    private  String name;
    private double price;
    private  String funding;
    private  String  status;
    private String brand;
    private  int last4;
    private  String object;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFunding() {
        return funding;
    }

    public void setFunding(String funding) {
        this.funding = funding;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLast4() {
        return last4;
    }

    public void setLast4(int last4) {
        this.last4 = last4;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Transactionmang{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", funding='" + funding + '\'' +
                ", status='" + status + '\'' +
                ", brand='" + brand + '\'' +
                ", last4=" + last4 +
                ", object='" + object + '\'' +
                '}';
    }
}

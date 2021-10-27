package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon_management")
public class CouponManagement {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long couponId;

    private String couponCode;
    private String couponDescription;
    private String couponType;
    private String couponValue;
    private String startDate;
    private String endDate;
    private String status;
    public CouponManagement() {
    }
    public long getCouponId() {
        return couponId;
    }
    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }
    public String getCouponCode() {
        return couponCode;
    }
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    public String getCouponDescription() {
        return couponDescription;
    }
    public void setCouponDescription(String couponDescription) {
        this.couponDescription = couponDescription;
    }
    public String getCouponType() {
        return couponType;
    }
    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }
    public String getCouponValue() {
        return couponValue;
    }
    public void setCouponValue(String couponValue) {
        this.couponValue = couponValue;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}

/*
"couponCode" : "Tech0005";
 "couponDescription" ="coupon";
"couponType";:"Dress",
 "couponValue:5
 "startDate=2/9/2021",
 "endDate"; 2/9/2022
 "status":false*/

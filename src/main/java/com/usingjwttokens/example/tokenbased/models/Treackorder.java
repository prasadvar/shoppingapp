package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;
import java.sql.Time;



public class Treackorder {

    /*@OneToOne
    @JoinColumn(name = "shippingid", referencedColumnName = "shippingid")*/
    private UserShipping userShipping;
    private  int k;

    public UserShipping getUserShipping() {
        return userShipping;
    }

    public void setUserShipping(UserShipping userShipping) {
        this.userShipping = userShipping;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "Treackorder{" +
                "userShipping=" + userShipping +
                ", k=" + k +
                '}';
    }
}

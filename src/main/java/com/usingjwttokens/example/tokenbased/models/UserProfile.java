package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "Profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userprofileid;
    @NotBlank(message = "Address1 is mandatory")
    private String address1;

    private String address2;
    @NotBlank(message = "City is mandatory")
    private String city;
    @NotBlank(message = "State is mandatory")
    private String state;
    @NotBlank(message = "District is mandatory")
    private String district;
    private int pinCode;
    @NotBlank(message = "Type is mandatory")
    private String type;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserProfile(String address1, String address2, String city, String state, String district, int pinCode,
                       String type) {
        super();
      this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.district = district;
        this.pinCode = pinCode;
        this.type = type;

    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        district = district;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public Long getUserprofileid() {
        return userprofileid;
    }

    public void setUserprofileid(Long userprofileid) {
        this.userprofileid = userprofileid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

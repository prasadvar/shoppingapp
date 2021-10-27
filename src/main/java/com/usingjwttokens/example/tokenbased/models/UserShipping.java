package com.usingjwttokens.example.tokenbased.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserShipping implements Serializable{
	private static final long serialVersionUID = 498745987L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shippingid;
	private String Type;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String State;
	private String District;
	private String Zipcode;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;

	public UserShipping() {
	}

	public Long getShippingid() {
		return shippingid;
	}

	public void setShippingid(Long shippingid) {
		this.shippingid = shippingid;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getDistrict() {
		return District;
	}

	public void setDistrict(String district) {
		District = district;
	}

	public String getZipcode() {
		return Zipcode;
	}

	public void setZipcode(String zipcode) {
		Zipcode = zipcode;
	}
	@JsonBackReference
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}

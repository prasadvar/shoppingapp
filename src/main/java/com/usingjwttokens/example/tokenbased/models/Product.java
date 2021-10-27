package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productid")
	private  Long productid;
	private  String title;
	private int price;
	private String description;
	private String categorys;
	private String type;
	private int instock;
    private String image;
    private double rating;
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Product() {
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategorys() {
		return categorys;
	}

	public void setCategorys(String categorys) {
		this.categorys = categorys;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}

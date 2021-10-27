package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "commentsid")
    private Long commentsid;
    private double rating;
    private String personname;
    private String comments;
    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private  Product product;
    public Comments() {
    }
    public Comments(Long commentsid, double rating, String personname, String comments, Product product) {
        this.commentsid = commentsid;
        this.rating = rating;
        this.personname = personname;
        this.comments = comments;
        this.product = product;
    }
    public Long getCommentsid() {
        return commentsid;
    }
    public void setCommentsid(Long commentsid) {
        this.commentsid = commentsid;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getPersonname() {
        return personname;
    }
    public void setPersonname(String personname) {
        this.personname = personname;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
}

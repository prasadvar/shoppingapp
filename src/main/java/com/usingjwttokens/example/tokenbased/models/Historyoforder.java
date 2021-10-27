package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;

@Entity
public class Historyoforder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long historyid;
    private  Long productid;
    private  String image;
    private String title;
    private String status;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
    public Long getHistoryid() {
        return historyid;
    }
    public void setHistoryid(Long historyid) {
        this.historyid = historyid;
    }
    public Long getProductid() {
        return productid;
    }
    public void setProductid(Long productid) {
        this.productid = productid;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}

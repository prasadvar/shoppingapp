package com.usingjwttokens.example.tokenbased.models;

import javax.persistence.*;

//this entity is to know details of the users who changed(Reset) there password
@Entity
@Table(	name = "status_of_reset_pwd")
public class StatusOfResetPassword {
    private  String userName;
    private boolean status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

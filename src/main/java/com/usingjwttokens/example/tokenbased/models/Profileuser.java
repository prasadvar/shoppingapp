package com.usingjwttokens.example.tokenbased.models;

public class Profileuser {
    private String username;

    private String firstname;
    private String email;

    public Profileuser(String username, String firstname, String email) {
        this.username = username;
        this.firstname = firstname;
        this.email = email;
    }
    public Profileuser() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

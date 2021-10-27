package com.usingjwttokens.example.tokenbased.models;

//import lombok.Data;
//import lombok.NoArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Mail 
{
	private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType = "text/plain";
    private List <Object> attachments;
    private Time expiryDate;

    public Time getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Time expiryDate) {
        this.expiryDate = expiryDate;
    }


    
    public Date getMailSendDate() {
        return new Date();
    }
}

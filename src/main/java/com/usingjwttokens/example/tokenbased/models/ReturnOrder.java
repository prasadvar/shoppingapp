package com.usingjwttokens.example.tokenbased.models;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name="returnorder")
 public class ReturnOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private Long paymentId;
    private String status;
    /*private String comment;
    private LocalDateTime createdAt;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   /* public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }*/

    public ReturnOrder(Long id, Long paymentId, String status) {
        this.id = id;
        this.paymentId = paymentId;
        this.status = status;
       /* this.comment = comment;
        this.createdAt = createdAt;*/
    }

    public ReturnOrder() {
    }
}
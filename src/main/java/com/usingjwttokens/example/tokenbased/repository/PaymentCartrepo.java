package com.usingjwttokens.example.tokenbased.repository;

import com.usingjwttokens.example.tokenbased.models.Paymentcarts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCartrepo extends JpaRepository<Paymentcarts,Long> {
}
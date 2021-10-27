package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.Transactionmang;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TransactionManagmentService {
    void save(Transactionmang transactionmang);

    List<Transactionmang> findAll();
}

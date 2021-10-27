package com.usingjwttokens.example.tokenbased.service.impl;

import com.usingjwttokens.example.tokenbased.models.Transactionmang;
import com.usingjwttokens.example.tokenbased.repository.Transactionmangrepo;
import com.usingjwttokens.example.tokenbased.service.TransactionManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionManagmentServiceImpl implements TransactionManagmentService {
    @Autowired
    Transactionmangrepo transactionmangrepo;

    public void save(Transactionmang transactionmang) {
        transactionmangrepo.save(transactionmang);
    }
    public List<Transactionmang> findAll(){
        return transactionmangrepo.findAll();
    }
}

package com.usingjwttokens.example.tokenbased.controllers;

import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Order;
import com.usingjwttokens.example.tokenbased.models.Transactionmang;
import com.usingjwttokens.example.tokenbased.service.TransactionManagmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/transaction")
public class TransactionManagmentController {

    @Autowired
    TransactionManagmentService transactionManagmentService;

    /*@PostMapping("/transactionData")
    public String saveTransactinData(@Valid @RequestBody Order newOrder, Principal principal) throws ResourceNotFoundException {
        Transactionmang transactionmang = new Transactionmang();
        transactionmang.setOrderId(newOrder.getOrderId());
        transactionmang.setName(newOrder.getName());
        transactionmang.setPrice(newOrder.getPrice());
        transactionmang.setFunding(newOrder.getFunding());
        //transactionmang.setStatus(newOrder.getstatus);
        transactionmang.setBrand(newOrder.getBrand());
        transactionmang.setLast4(newOrder.getLast4());
        transactionmang.setObject(newOrder.getObject());
        transactionmang.setStatus("Success");
        transactionManagmentService.save(transactionmang);
        return "saved";
    }*/
    @GetMapping("/sendTransactionData")
    public List<Transactionmang> displayTransactinData() throws ResourceNotFoundException {
        return  transactionManagmentService.findAll();
    }

}

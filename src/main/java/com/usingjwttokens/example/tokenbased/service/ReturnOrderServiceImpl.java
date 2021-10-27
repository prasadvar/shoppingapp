package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Historyoforder;
import com.usingjwttokens.example.tokenbased.models.Paymentcarts;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.models.ReturnOrder;
import com.usingjwttokens.example.tokenbased.repository.Historyoforderrepo;
import com.usingjwttokens.example.tokenbased.repository.PaymentCartrepo;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import com.usingjwttokens.example.tokenbased.repository.ReturnOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
public class ReturnOrderServiceImpl implements ReturnOrderSerivce {
    @Autowired
    private Productrepos productrepos;
    @Autowired
    private Historyoforderrepo historyoforderrepo;
    @Autowired
    private ReturnOrderRepository returnOrderRepository;
    @Autowired
    private PaymentCartrepo paymentCartrepo;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();



    @Override
    public ReturnOrder addReturnOrder(ReturnOrder returnOrder) {
        return returnOrderRepository.save(returnOrder);
    }




    @Override
    public ReturnOrder removeReturnOrder(Long id) throws ResourceNotFoundException {
        Optional<ReturnOrder> returnOrder = returnOrderRepository.findById(id);
        if (!returnOrder.isPresent()) {
            throw new ResourceNotFoundException("Return Order  not found");
        }
        returnOrderRepository.delete(returnOrder.get());
        return returnOrder.get();
    }

    @Override
    public ReturnOrder updateReturnOrder(Long id, ReturnOrder returnOrder) throws ResourceNotFoundException {

        Optional<ReturnOrder> order1 = returnOrderRepository.findById(id);
        if (!order1.isPresent()) {
            throw new ResourceNotFoundException("No Exception");
        } else {
            ReturnOrder oldreturnOrder = order1.get();
            returnOrder.setId(id);
            returnOrder.setPaymentId(oldreturnOrder.getPaymentId());

            //check and update history order if status is approved
            if(returnOrder.getStatus().equals("approved")){
                Optional<Paymentcarts> paym= paymentCartrepo.findById(oldreturnOrder.getPaymentId());
                Paymentcarts ott= paym.get();
                Historyoforder history =new Historyoforder();
                history.setProductid(ott.getProduct().getProductid());
                history.setImage(ott.getProduct().getImage());
                history.setTitle(ott.getProduct().getTitle());
                history.setUser(ott.getUser());
                history.setStatus("Return order pending");
                historyoforderrepo.save(history);

            }

            return returnOrderRepository.save(returnOrder);
        }
    }

    @Override
    public ReturnOrder getReturnOrderDetails(Long id) throws ResourceNotFoundException {
        Optional<ReturnOrder> returnOrder = returnOrderRepository.findById(id);
        if (!returnOrder.isPresent()) {
            throw new ResourceNotFoundException("Order not found");
        }
        return returnOrder.get();
    }

    @Override
    public List<ReturnOrder> getAllReturnOrders() {
        return returnOrderRepository.findAll();
    }

}

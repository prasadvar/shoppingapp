package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.ReturnOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReturnOrderSerivce {
    public ReturnOrder addReturnOrder(ReturnOrder returnOrder);
    public ReturnOrder removeReturnOrder(Long id) throws ResourceNotFoundException; //Cancel the Order
    public ReturnOrder  updateReturnOrder(Long id, ReturnOrder returnOrder) throws ResourceNotFoundException;
    public ReturnOrder getReturnOrderDetails(Long id) throws ResourceNotFoundException ;
    public List<ReturnOrder> getAllReturnOrders();
}

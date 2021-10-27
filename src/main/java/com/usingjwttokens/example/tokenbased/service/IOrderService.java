package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Order;
import com.usingjwttokens.example.tokenbased.models.ReturnOrder;

import java.util.List;

public interface IOrderService {
    public Order addOrder(Order order);
    public Order reOrder(Long orderId);
    public Order removeOrder(Long orderId) throws ResourceNotFoundException; //Cancel the Order
    public Order  updateOrder(Long orderId, Order order) throws ResourceNotFoundException;
    public Order getOrderDetails(Long orderId) throws ResourceNotFoundException ;
    public List<Order> getAllOrders();
    public ReturnOrder cancelOrder(Long orderId, ReturnOrder returnOrder);
}

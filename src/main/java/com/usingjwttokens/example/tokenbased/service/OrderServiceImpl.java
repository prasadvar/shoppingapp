package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Order;
import com.usingjwttokens.example.tokenbased.models.ReturnOrder;
import com.usingjwttokens.example.tokenbased.repository.IOrderRepository;
import com.usingjwttokens.example.tokenbased.repository.ReturnOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private ReturnOrderRepository returnOrderRepository;

    @Autowired
    private IOrderRepository orderRepository;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();



    @Override
    public Order addOrder(Order order) {
        order.setBillingDate(now);
        return orderRepository.save(order);
    }
    public Order reOrder(Long orderId)
    {
        Optional<Order> order = orderRepository.findById(orderId);

        Order oldOrder = order.get();
        Order newOrder = new Order();
        newOrder.setName(oldOrder.getName());
        newOrder.setBrand(oldOrder.getBrand());
        newOrder.setObject(oldOrder.getObject());
        newOrder.setFunding(oldOrder.getFunding());
        newOrder.setPrice(oldOrder.getPrice());
        newOrder.setPaycartS(oldOrder.getPaycartS());
        newOrder.setLast4(oldOrder.getLast4());
        newOrder.setBillingDate(oldOrder.getBillingDate());


        // newOrder.setPaycartS(oldOrder.getPaycartS());

        newOrder.setBillingDate(now);
        return orderRepository.save(newOrder);

    }


    @Override
    public Order removeOrder(Long orderId) throws ResourceNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order not found");
        }
        orderRepository.delete(order.get());
        return order.get();
    }
    @Override
    public ReturnOrder cancelOrder(Long PaymentId, ReturnOrder returnOrder) {
        returnOrder.setPaymentId(PaymentId);
        returnOrder.setStatus("pending");
        return returnOrderRepository.save(returnOrder);
    }
    @Override
    public Order updateOrder(Long orderId, Order order) throws ResourceNotFoundException {

        Optional<Order> order1 = orderRepository.findById(orderId);
        if (!order1.isPresent()) {
            throw new ResourceNotFoundException("No Exception");
        } else {
            order.setOrderId(orderId);
            return orderRepository.save(order);
        }
    }

    @Override
    public Order getOrderDetails(Long orderId) throws ResourceNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order not found");
        }
        return order.get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}

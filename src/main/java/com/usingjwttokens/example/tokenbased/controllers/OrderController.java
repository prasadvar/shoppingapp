package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.*;
import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.repository.Historyoforderrepo;
import com.usingjwttokens.example.tokenbased.repository.IOrderRepository;
import com.usingjwttokens.example.tokenbased.repository.PaymentCartrepo;
import com.usingjwttokens.example.tokenbased.service.*;
import com.usingjwttokens.example.tokenbased.service.impl.UserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.validation.Valid;
import java.security.Principal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    IOrderRepository iOrderRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private PaymentCartrepo paymentCartrepo;
    @Autowired
    private UserrService userService;
    @Autowired
    private Productservice productservice;
    @Autowired
    private Historyoforderrepo historyoforderrepo;
    @Autowired
    TransactionManagmentService transactionManagmentService;


    //Proceed the Order
    @PostMapping("/order/add")
    public Order addOrder(@Valid @RequestBody Order newOrder, Principal principal) throws ResourceNotFoundException {

        Set<Paymentcarts> one= newOrder.getPaycartS();
        for (Paymentcarts cards:one)
        {
            cards.getProduct().setInstock(cards.getProduct().getInstock()-cards.getQuantity());
            productservice.updateproduct(cards.getProduct().getProductid(),cards.getProduct());
        }
        orderService.addOrder(newOrder);
        String name="";
        for(Paymentcarts w:one)
        {
            name= w.getUser().getUsername();
            break;
        }
        //code to save transaction
        Transactionmang transactionmang = new Transactionmang();
        transactionmang.setOrderId(newOrder.getOrderId());
        transactionmang.setName(newOrder.getName());
        transactionmang.setPrice(newOrder.getPrice());
        transactionmang.setFunding(newOrder.getFunding());
        transactionmang.setBrand(newOrder.getBrand());
        transactionmang.setLast4(newOrder.getLast4());
        transactionmang.setObject(newOrder.getObject());
        transactionmang.setStatus("Success");
        transactionManagmentService.save(transactionmang);

        cartService.deleteall(name);
      return  newOrder;
    }
    @PostMapping("/order/reorder/{Id}")
    public Order reOrder(@PathVariable("Id") Long orderId)
    {
        return orderService.reOrder(orderId);
    }
    @PostMapping("/order/cancel/{Id}")
    public ReturnOrder cancelOrder(@PathVariable("Id") Long PaymentId,@RequestBody ReturnOrder returnOrder)
    {
        return orderService.cancelOrder(PaymentId,returnOrder);
    }
    @RequestMapping(value ="/order/id/{orderId}", method = RequestMethod.GET)
    public Order getOrderDetails(@PathVariable(value = "orderId",required = false) Long orderId) throws ResourceNotFoundException{
        Order order = orderService.getOrderDetails(orderId);
        if(order==null) {
            throw new ResourceNotFoundException("Not Found");
        }			return order;
    }
    @RequestMapping(value="/order/all", method=RequestMethod.GET)
    public List<Order> getAllOrders(Principal principal){
        //@PathVariable(value = "mobile",required = false) String name,
        User user= userService.findByUsername(principal.getName());
        List<Order>  all=orderService.getAllOrders();
        List<UserShipping> ship= user.getUserShippingList();
        return all.stream()
                .filter((ord)->{
                    for(UserShipping shops:ship)
                    {
                        if(shops.getShippingid()==ord.getUserShipping().getShippingid())
                        {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
    @RequestMapping(value = "/deletecart/{id}", method = RequestMethod.GET)
    public  ResponseEntity<?> deletecarybyid(@PathVariable(value = "id",required = false) Long id)
    {
        Optional<Paymentcarts> paym= paymentCartrepo.findById(id);
       Paymentcarts ott= paym.get();
       Historyoforder history =new Historyoforder();
       history.setProductid(ott.getProduct().getProductid());
       history.setImage(ott.getProduct().getImage());
       history.setTitle(ott.getProduct().getTitle());
       history.setUser(ott.getUser());
       history.setStatus("Order cancelled");
       historyoforderrepo.save(history);
        paymentCartrepo.delete(paym.get());
        return ResponseEntity.ok(new MessageResponse("product cancelled succesfully"));
    }

    @RequestMapping(value="/trackorder/{carotid}", method = RequestMethod.GET)
    public Treackorder trackingorder(@PathVariable(value = "carotid",required = false) Long id)
    {
        LocalDateTime t1=LocalDateTime.now();
        Optional<Paymentcarts> paym= paymentCartrepo.findById(id);
        Paymentcarts ott= paym.get();
       Long ordsid= ott.getOrder().getOrderId();
        Treackorder treackorder=new Treackorder();
        int k=0;
        Optional<Order> orders=iOrderRepository.findById(ordsid);
        Order ord=orders.get();
                treackorder.setUserShipping(ord.getUserShipping());
                Duration d1=Duration.between(ord.getBillingDate(),t1);
                k= (int) d1.toMinutes();
                k=k*10;
                if(k>100)
                {
                    Historyoforder history =new Historyoforder();
                    history.setProductid(ott.getProduct().getProductid());
                    history.setImage(ott.getProduct().getImage());
                    history.setTitle(ott.getProduct().getTitle());
                    history.setUser(ott.getUser());
                    history.setStatus("order delivered successfully");
                    historyoforderrepo.save(history);
                    paymentCartrepo.delete(paym.get());
                }
        treackorder.setK(k);
        return treackorder;
    }
    @RequestMapping(value="/history/all", method=RequestMethod.GET)
    public List<Historyoforder> allhistory(Principal principal)
    {
       List<Historyoforder> history= historyoforderrepo.findAll();
        User user= userService.findByUsername(principal.getName());
      return history.stream()
               .filter((hist)->hist.getUser().getId()==user.getId())
               .collect(Collectors.toList());
    }
}
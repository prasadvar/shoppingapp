package com.usingjwttokens.example.tokenbased.controllers;



import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.ReturnOrder;
import com.usingjwttokens.example.tokenbased.service.ReturnOrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/api")
public class ReturnOrderController {
    @Autowired
    private ReturnOrderSerivce returnOrderSerivce;
    //Proceed the Order
    @PostMapping("/returnorder/add")
    public ReturnOrder addReturnOrder(@Valid @RequestBody ReturnOrder newOrder) {
      return returnOrderSerivce.addReturnOrder(newOrder);
    }
    //Delete the order or Cancel the order
    @RequestMapping(value = "/returnorder/remove/{id}", method = RequestMethod.DELETE)
    public ReturnOrder removeReturnOrder(@PathVariable(value = "id",required = false) long orderId) throws ResourceNotFoundException {
        ReturnOrder returnOrder = returnOrderSerivce.removeReturnOrder(orderId);
        if(returnOrder==null) {
            throw new ResourceNotFoundException("Not Found");
        }
        return returnOrder;
    }
    //Any changes in Order
    @RequestMapping(value = "/returnorder/update/{id}", method = RequestMethod.PUT)
    public ReturnOrder updateReturnOrder(@PathVariable(value = "id",required = false) long id,@Valid @RequestBody ReturnOrder returnOrder) throws ResourceNotFoundException{
        ReturnOrder order1 = returnOrderSerivce.updateReturnOrder(id,returnOrder);
        if (order1 == null) {
            throw new ResourceNotFoundException("Not Order Found");
        }
        return order1;
    }
    //History of Orders
    @RequestMapping(value="/returnorder/all", method=RequestMethod.GET)
    public List<ReturnOrder> getAllOrders(){
        return returnOrderSerivce.getAllReturnOrders();
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

}
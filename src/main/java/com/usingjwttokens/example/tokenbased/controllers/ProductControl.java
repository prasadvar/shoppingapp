package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Order;
import com.usingjwttokens.example.tokenbased.models.Product;

import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import com.usingjwttokens.example.tokenbased.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping(value = "/product")
class ProductControl {
@Autowired
   private Productrepos productrepos;
    @Autowired
    Productservice productservice;

    @RequestMapping(value = "/saved", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<? extends Serializable> save(@RequestParam("titles") String title, @RequestParam("prices")int price, @RequestParam("descriptions")String description, @RequestParam("categorys")String category, @RequestParam("types")String type,@RequestParam("instocks") int instock) {
        try {
            Product products=new Product();
            products.setTitle(title);
            products.setPrice(price);
            products.setDescription(description);
            products.setCategorys(category);
            products.setType(type);
            products.setInstock(instock);
            productrepos.save(products);
            return new ResponseEntity<String>("Working Fine", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<String>("not",HttpStatus.OK);
        }
    }

    @PostMapping("/addup")
    public ResponseEntity<?> addingprod(@Valid @RequestBody Product product)
    {
        Product products=new Product();
        productrepos.save(products);
        return ResponseEntity.ok(new MessageResponse("successfully!"));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public HttpEntity<? extends Serializable> delete(@RequestBody Product product) {
        try{
            productservice.delete(product);
            return new ResponseEntity<String>("Working Fine", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<? extends Serializable> getAllProduct() {
        try {
            List<Product> productResponse = (List<Product>) productservice.getAllProduct();
            return new ResponseEntity <String> ("working",HttpStatus.ACCEPTED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
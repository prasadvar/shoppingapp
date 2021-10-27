package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Productservice {
    public Product savepro(Product product);
    public void delete(Product product);
    public List<Product> getAllProduct();
    public Product updateCart(Product product);
    public Product updateproduct(Long productid, Product product) throws ResourceNotFoundException;
}

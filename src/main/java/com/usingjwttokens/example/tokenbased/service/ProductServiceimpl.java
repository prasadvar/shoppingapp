package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.exception.ResourceNotFoundException;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("ServiceImpl")
public class ProductServiceimpl implements Productservice{
    @Autowired
    private Productrepos productrepos;
    @Transactional
    public Product savepro(Product product)
    {
        productrepos.save(product);
        return product;
    }

    @Transactional
    public void delete(Product product) {
        productrepos.delete(product);
    }
    @Transactional(readOnly = true)
    public List<Product> getAllProduct() {
        List<Product> ProductResponse = (List<Product>) productrepos.findAll();
        return ProductResponse;
    }

    @Override
    public Product updateCart(Product product) {
        return productrepos.save(product);
    }

    @Override
    public Product updateproduct(Long productid, Product product) throws ResourceNotFoundException {
            Optional<Product> product123 = productrepos.findById(productid);
            if (!product123.isPresent()) {
                throw new ResourceNotFoundException("No Exception");
            } else {
                product.setProductid(productid);
                return productrepos.save(product);
            }
    }


}

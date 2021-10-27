package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.models.Cart;

import java.util.List;


//import com.cg.exception.ResourceNotFoundException;

public interface CartService {
    public Cart addCart(Cart cart);
    public Cart deleteCart(long cartId);
    public Cart updateCart(long cartId, Cart cart);
    public Cart getCartDetails(long cartId);
    public List<Cart> getAllCartDetails();

    public void deleteall(String username);
}


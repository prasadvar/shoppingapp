package com.usingjwttokens.example.tokenbased.service;



import com.usingjwttokens.example.tokenbased.models.Cart;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.repository.CartRepository;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepo;


    @Autowired
    private Productrepos productrepos;
    @Autowired
    private CartService cartService;



    @Override
    public Cart addCart(Cart cart){
        return cartRepo.save(cart);
    }

    @Override
    public Cart deleteCart(long cartId){
        Optional<Cart> cart = cartRepo.findById(cartId);
        cartRepo.delete(cart.get());
        return cart.get();
    }

    @Override
    public Cart updateCart(long cartId, Cart cart) {

        Optional<Cart> cart1 = cartRepo.findById(cartId);


        int quantity = cart.getQuantity();
        double sum = 0;
        for (int i = 1; i <= quantity; i++) {
            sum = sum + cart.getProduct().getPrice();
            cart.setTotal(sum);

        }
        return cartRepo.save(cart);
    }

    @Override
    public Cart getCartDetails(long cartId){
        Optional<Cart> cart = cartRepo.findById(cartId);

        return cart.get();

    }
      @Override
    public List<Cart> getAllCartDetails() {
        return cartRepo.findAll();
    }

    @Override
    public void deleteall(String username) {
        List<Cart> all = cartRepo.findAll();
        all.stream()
                .map((crt) ->
                {
                    if (crt.getUser().getUsername().equals(username)) {
                        cartService.deleteCart(crt.getCartid());
                        return true;
                    }
                    return false;
                })
                .count();

    }

}


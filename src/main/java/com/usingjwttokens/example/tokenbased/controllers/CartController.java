package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.models.Cart;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.repository.CartRepository;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import com.usingjwttokens.example.tokenbased.repository.UserRepository;
import com.usingjwttokens.example.tokenbased.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private Productrepos productrepos;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CartController(CartService cartService, CartRepository cartRepository) {
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

    @PostMapping("/cart/add/{mobileNo}/{productid}")
    public ResponseEntity<?> addCart(@PathVariable(value = "mobileNo", required = false) String mobile, @PathVariable(value = "productid", required = false) Long id) throws IOException {
        Cart cart = new Cart();
        Optional<Product> product = productrepos.findById(id);
        cart.setProduct(product.get());
        cart.setQuantity(1);
        int quantity = cart.getQuantity();
        Optional<User> user = userRepository.findByUsername(mobile);
        cart.setUser(user.get());
        double sum = 0;
        for (int i = 1; i <= quantity; i++) {
            sum = sum + cart.getProduct().getPrice();
        }
        cart.setTotal(sum);
        List<Cart> all = cartRepository.findAll();
        Long total = all.stream()
                .filter((cat) -> cat.getUser().getUsername().equals(mobile))
                .filter((cat) -> {
                    if (cat.getProduct().getProductid() == id) {
                        cat.setQuantity(cat.getQuantity() + 1);
                        cartService.updateCart(cat.getCartid(), cat);
                        return true;
                    }
                    return false;
                })
                .count();
        if (total == 0) {
            cartService.addCart(cart);
            return ResponseEntity.ok(new MessageResponse("producted added to cart"));
        } else {
            return ResponseEntity.ok(new MessageResponse("product added to existing cart"));
        }
    }

    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.DELETE)
    public List<Cart> deleteCart(@PathVariable(value = "id", required = false) long cartId) {
        Cart cart = cartService.deleteCart(cartId);
        String mobile = cart.getUser().getUsername();
        List<Cart> all = cartRepository.findAll();
        return all.stream()
                .filter((crt) -> crt.getUser().getUsername().equals(mobile))
                .collect(Collectors.toList());
    }
    @RequestMapping(value = "/cart/deleteall/{mobilenumber}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteusercart(@PathVariable(value = "mobilenumber", required = false) String username) {
        cartService.deleteall(username);
        return ResponseEntity.ok(new MessageResponse("cart is empty"));
    }

    @RequestMapping(value = "/cart/update/{id}", method = RequestMethod.PUT)
    public Cart updateCart(@PathVariable("id") long cartId, @Valid @RequestBody Cart cart) {
        Cart Cart1 = cartService.updateCart(cartId, cart);
        return Cart1;
    }
    @RequestMapping(value = "/cart/id/{cartId}", method = RequestMethod.GET)
    public Cart getCartDetails(@PathVariable("cartId") long cartId) {
        Cart Cart = cartService.getCartDetails(cartId);
        return Cart;
    }
    @RequestMapping(value = "/cart/all/{mobilenumber}", method = RequestMethod.GET)
    public List<Cart> getAllCartDetails(@PathVariable(value = "mobilenumber", required = false) String username) {
        List<Cart> all = cartService.getAllCartDetails();
        return all.stream()
                .filter((cat) -> cat.getUser().getUsername().equals(username))
                .collect(Collectors.toList());
    }
}

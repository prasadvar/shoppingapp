package com.usingjwttokens.example.tokenbased.controllers;

import com.usingjwttokens.example.tokenbased.models.Comments;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.repository.Productrepos;
import com.usingjwttokens.example.tokenbased.service.Commentsservice;
import com.usingjwttokens.example.tokenbased.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private Commentsservice commentsservice;
    @Autowired
    private Productrepos productrepos;
    @Autowired
    private Productservice productservice;

    @PostMapping("/addcoments/{id}")
    public  ResponseEntity<?> savedata(@Valid @RequestBody Comments comments, @PathVariable(value = "id",required = false) Long id)
    {
        Optional<Product> product=productrepos.findById(id);
        comments.setProduct(product.get());
        commentsservice.saveme(comments);
        return ResponseEntity.ok(new MessageResponse("comments have added"));
    }
    @RequestMapping("/toseecoments/{id}")
    public List<Comments> findaall(@PathVariable(value = "id",required = false) Long id)
    {
        Product product1234=new Product();
        double value=0.0;
        int sum=0;
        List<Comments> all=commentsservice.findingall();
     for(Comments cmt:all){
         if(cmt.getProduct().getProductid()==id) {
             value += cmt.getRating();
             sum++;
         }
         if(sum==1)
         {
             product1234= cmt.getProduct();
         }
     }
        product1234.setRating(value/sum);
     productservice.updateCart(product1234);
     return all.stream()
             .filter((com)->com.getProduct().getProductid()==id)
             .collect(Collectors.toList());
    }
}

package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.models.Category;
import com.usingjwttokens.example.tokenbased.models.MegaCategory;
import com.usingjwttokens.example.tokenbased.models.Productlist;
import com.usingjwttokens.example.tokenbased.repository.CategoryRepository;
import com.usingjwttokens.example.tokenbased.repository.MegaCategoryrepo;
import com.usingjwttokens.example.tokenbased.repository.Productlistrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping(value = "/lists")
public class produtlistcontroler {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Productlistrepo productlistrepo;
    @Autowired
    private MegaCategoryrepo megaCategoryrepo;
    @Autowired
    public produtlistcontroler(Productlistrepo productRepository, CategoryRepository categoryRepository) {
        this.productlistrepo = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @PostMapping("/addingcartproduct")
    public ResponseEntity<Productlist> create(@ModelAttribute Productlist product) throws IOException {

        Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getCategoryId());
        if (!optionalCategory.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        product.setCategory(optionalCategory.get());

        Productlist savedProduct = productlistrepo.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getCategory()).toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }
    @GetMapping("/productlistcategoryt")
    @ResponseBody
    public List<MegaCategory> findall()
    {
        return megaCategoryrepo.findAll();
    }
}

package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.service.SelectIteamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/produtslist")
public class Retrivingfromproducts {
    @Autowired
    private SelectIteamsService selectIteamsService;
    @GetMapping("/display")
    public List<Product> search()
    {
       return selectIteamsService.findall();
     /* return all.stream()
               .filter((prod)->prod.getType().equals(iteams) && prod.getCategory().equals(category))
              .sorted(Comparator.comparingDouble(Product::getPrice).reversed().thenComparingInt(Product::getInstock).reversed())
               .collect(Collectors.toList());*/
    }
    @RequestMapping("/id/{Id}")
    public Optional<Product> findbyId(@PathVariable("Id") Long productid)
    {
        return selectIteamsService.Findbyid(productid);
    }
}

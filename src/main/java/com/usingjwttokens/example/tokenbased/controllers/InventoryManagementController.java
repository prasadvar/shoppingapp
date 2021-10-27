package com.usingjwttokens.example.tokenbased.controllers;

import com.usingjwttokens.example.tokenbased.models.Inventory;
import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventory")
public class InventoryManagementController {

    @Autowired
    Productservice productservice;
    @RequestMapping(value = "/getAllData", method = RequestMethod.GET)
    @ResponseBody
    public List<Inventory> inventoryData() {
        List<Product> inventoryList = new ArrayList<>();
        inventoryList = productservice.getAllProduct();
        List<Inventory> selectList = new ArrayList<>();
        Inventory inv;
        for (Product productList : inventoryList) {
            inv = new Inventory();
            inv.setAvailable(productList.getInstock());
            inv.setCategory(productList.getCategorys());
            inv.setImage(productList.getImage());
   //         inv.setNoofproducts(productList.getQuantity());
            inv.setType(productList.getType());
           // inv.setSoldQty(productList.getSoldQty());
            inv.setSoldQty(productList.getTotal()-productList.getInstock());
            selectList.add(inv);
        }
        return selectList;
    }

}

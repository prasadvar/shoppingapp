package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.repository.SelectingIteamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelectIteamsService {
    @Autowired
    private SelectingIteamsRepository selectingIteamsRepository;

    public List<Product> findall()
    {
        return selectingIteamsRepository.findAll();
    }

    public Optional<Product> Findbyid(Long productid)
    {
        return selectingIteamsRepository.findById(productid);
    }
}

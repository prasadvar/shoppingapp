package com.usingjwttokens.example.tokenbased.repository;

import com.usingjwttokens.example.tokenbased.models.Productlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productlistrepo extends JpaRepository<Productlist, Long> {
}

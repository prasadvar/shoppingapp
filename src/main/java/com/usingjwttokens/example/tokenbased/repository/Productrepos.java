package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.Product;
import com.usingjwttokens.example.tokenbased.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Productrepos extends JpaRepository<Product, Long> {
  /*  @Query("SELECT u FROM Product u WHERE u.productid = :username")
    Optional<Product> findByUsername(Long productid);*/
   /* @Query("UPDATE Product p SET p.rating = :ratings WHERE p.productid = :id")
    void updateByquality(@Param("ratings") double ratings, @Param("id") Long id);*/
}

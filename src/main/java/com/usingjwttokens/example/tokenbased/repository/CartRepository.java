package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

public interface CartRepository extends JpaRepository<Cart,Long>{
  /*  @Query("DELETE FROM cartbe u WHERE u.id = :Id ")
   void deletebyuserid(Long Id);*/

}
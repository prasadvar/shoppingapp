package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

}

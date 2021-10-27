package com.usingjwttokens.example.tokenbased.repository;

import com.usingjwttokens.example.tokenbased.models.Transactionmang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transactionmangrepo extends JpaRepository<Transactionmang, Long> {
}

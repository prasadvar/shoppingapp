package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserrRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();

}

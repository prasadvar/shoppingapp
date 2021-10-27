package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u WHERE u.username = :username")
	Optional<User> findByUsername(String username);

	/*@Query("SELECT u FROM User u WHERE u.username = :username")
	User findByname(String username);*/

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);


	@Query("SELECT u FROM User u WHERE u.username = :mobile")
	User findByEmailByMobile(String mobile);

	@Transactional
	@Modifying
	@Query("update User e set e.password = password where e.username = username")
	void update(String username,String password);
}

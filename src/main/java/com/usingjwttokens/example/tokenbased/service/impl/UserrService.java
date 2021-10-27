package com.usingjwttokens.example.tokenbased.service.impl;



import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.models.UserShipping;

import java.util.Optional;

public interface UserrService {
	


	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User save(User user);
	
	Optional<User> findById(Long id);
	

	

	
	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultShipping(Long userShippingId, User user);

	void delete(Long userShippingId, User user);


	
}

package com.usingjwttokens.example.tokenbased.service.impl;


import com.usingjwttokens.example.tokenbased.models.UserShipping;

import java.util.Optional;

public interface UserShippingService {
	
	Optional<UserShipping> findById(Long id);
	void removeById(Long id);


}

package com.usingjwttokens.example.tokenbased.service.impl;


import com.usingjwttokens.example.tokenbased.models.UserShipping;
import com.usingjwttokens.example.tokenbased.repository.UserShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public Optional<UserShipping> findById(Long id) {
		return userShippingRepository.findById(id);
	}
	public void removeById(Long id) {

	}
	

}

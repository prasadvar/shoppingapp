package com.usingjwttokens.example.tokenbased.service.impl;

import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.models.UserShipping;
import com.usingjwttokens.example.tokenbased.repository.UserShippingRepository;
import com.usingjwttokens.example.tokenbased.repository.UserrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserrServiceImpl implements UserrService {

	private static final Logger LOG = LoggerFactory.getLogger(UserrService.class);

	@Autowired
	private UserrRepository userRepository;


	@Autowired
	private UserShippingRepository userShippingRepository;


	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}


	@Override
	public void updateUserShipping(UserShipping userShipping, User user) {
		userShipping.setUser(user);
		user.getUserShippingList().add(userShipping);

		save(user);
	}

	@Override
	public void setUserDefaultShipping(Long userShippingId, User user) {
		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();

		for (UserShipping userShipping : userShippingList) {
			if (userShipping.getShippingid() == userShippingId) {
				userShippingRepository.save(userShipping);
			} else {
				userShippingRepository.save(userShipping);
			}
		}

	}

	@Override
	public void delete(Long userShippingId, User user) {
		List<UserShipping> userShippingList = (List<UserShipping>) userShippingRepository.findAll();

		for (UserShipping userShipping : userShippingList) {
			if (userShipping.getShippingid() == userShippingId) {
				userShippingRepository.delete(userShipping);

			}
		}
	}
}

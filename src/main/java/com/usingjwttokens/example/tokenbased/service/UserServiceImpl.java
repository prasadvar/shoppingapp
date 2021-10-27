package com.usingjwttokens.example.tokenbased.service;



import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User getEmail(String email) {
        return userRepository.findByEmailByMobile(email);
    }

    public User getUserDetails(String mobile) {
        return userRepository.findByEmailByMobile(mobile);
    }

    public void save(User user) {
        userRepository.update(user.getUsername(), user.getPassword());
    }

    public List<User> getAllUserDetails(){
        return userRepository.findAll();
    }
}

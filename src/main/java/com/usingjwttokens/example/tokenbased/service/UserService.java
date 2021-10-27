package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.models.User;

import java.util.List;

public interface UserService {
    User getEmail(String email);

    User getUserDetails(String mobile);

    void save(User userDao);

    List<User> getAllUserDetails();
}

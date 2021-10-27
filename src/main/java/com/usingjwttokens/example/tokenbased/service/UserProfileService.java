package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.UserProfile;
import com.usingjwttokens.example.tokenbased.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userRepository;

    public UserProfile saveUser(UserProfile userprofile)
    {
        return userRepository.save(userprofile);
    }

    public List<UserProfile> getAllUsers()
    {
        List users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    //Update row in table
    public UserProfile updateUser(Long userprofile, UserProfile userProfile) {
        userRepository.save(userProfile);
        return userProfile;
    }
}

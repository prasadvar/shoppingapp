package com.usingjwttokens.example.tokenbased.controllers;


import com.usingjwttokens.example.tokenbased.models.UserProfile;
import com.usingjwttokens.example.tokenbased.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/userprofile")
public class UserProfileController {
    @Autowired
    private UserProfileService userService;
    //Add the address
    @PostMapping("/profile")
    public UserProfile saveUser(@RequestBody UserProfile userprofile)
    {
        return userService.saveUser(userprofile);
    }
    // Get all the addresses
    @GetMapping("/getallusers")
    public List<UserProfile> getAllUsers()
    {
        return userService.getAllUsers();
    }
    //Update the Address
    @PutMapping("/profile/{number}")
    public UserProfile updateUser(@RequestBody UserProfile userProfile, @PathVariable Long number)
    {
        return userService.updateUser(number,userProfile);

    }
}


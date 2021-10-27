package com.usingjwttokens.example.tokenbased.controllers;

import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.models.UserDataForAdmin;
import com.usingjwttokens.example.tokenbased.models.UserDataForResetPwdAdmin;
import com.usingjwttokens.example.tokenbased.service.StatusOfResetPasswordService;
import com.usingjwttokens.example.tokenbased.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/userData")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StatusOfResetPasswordService statusOfResetPasswordService;
    @RequestMapping(value = "/getallUserDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDataForAdmin> getAllUserDetails() {
        UserDataForAdmin userDataForAdmin;
        List<User> userList = userService.getAllUserDetails();
        List<UserDataForAdmin> userDataForAdmins = new ArrayList<>();
        for (User list : userList) {
            userDataForAdmin = new UserDataForAdmin();
            userDataForAdmin.setUserName(list.getFirstname());
            userDataForAdmin.setEmail(list.getEmail());
            userDataForAdmin.setMobile(list.getUsername());
            userDataForAdmins.add(userDataForAdmin);
        }
        return userDataForAdmins;
    }
    @RequestMapping(value = "/userRestPwdDetails", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDataForResetPwdAdmin> userRestPwdDetails() {
        UserDataForResetPwdAdmin userDataForResetPwdAdmin;
        List<User> userList = userService.getAllUserDetails();
        List<String> listStatus = statusOfResetPasswordService.getAllStatus();
        List<UserDataForResetPwdAdmin> userDataForResetPwdAdminList = new ArrayList<>();
        for (User list : userList) {
            if(listStatus.contains(list.getUsername())) {
                userDataForResetPwdAdmin = new UserDataForResetPwdAdmin();
                userDataForResetPwdAdmin.setUserName(list.getFirstname());
                userDataForResetPwdAdmin.setEmail(list.getEmail());
                userDataForResetPwdAdmin.setMobile(list.getUsername());
                userDataForResetPwdAdmin.setPassword(list.getPassword());
                userDataForResetPwdAdminList.add(userDataForResetPwdAdmin);
            }
        }
        return userDataForResetPwdAdminList;
    }
}

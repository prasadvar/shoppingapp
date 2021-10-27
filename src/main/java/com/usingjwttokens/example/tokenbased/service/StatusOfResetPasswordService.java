package com.usingjwttokens.example.tokenbased.service;


import com.usingjwttokens.example.tokenbased.models.StatusOfResetPassword;

import java.util.List;

public interface StatusOfResetPasswordService {

    StatusOfResetPassword findUserByMobileNo(String mobile);

    void save(StatusOfResetPassword statusOfResetPassword);

    List<String> getAllStatus();
}

package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.StatusOfResetPassword;
import com.usingjwttokens.example.tokenbased.repository.StatusOfResetPasswordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusOfResetPasswordServiceImpl implements StatusOfResetPasswordService {

    @Autowired
    StatusOfResetPasswordRepo statusOfResetPasswordRepo;

    public StatusOfResetPassword findUserByMobileNo(String mobile) {
        return statusOfResetPasswordRepo.findUserByMobile(mobile);
    }
    public void save(StatusOfResetPassword statusOfResetPassword){
        statusOfResetPasswordRepo.save(statusOfResetPassword);
    }
    public  List<String> getAllStatus(){
        return  statusOfResetPasswordRepo.getAllStatus();

    }

}

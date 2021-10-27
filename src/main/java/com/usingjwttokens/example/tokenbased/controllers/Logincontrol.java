package com.usingjwttokens.example.tokenbased.controllers;



import com.usingjwttokens.example.tokenbased.models.Mail;
import com.usingjwttokens.example.tokenbased.models.StatusOfResetPassword;
import com.usingjwttokens.example.tokenbased.models.User;
import com.usingjwttokens.example.tokenbased.models.ValidatePasswordObject;
import com.usingjwttokens.example.tokenbased.payload.response.MessageResponse;
import com.usingjwttokens.example.tokenbased.service.MailService;
import com.usingjwttokens.example.tokenbased.service.StatusOfResetPasswordService;
import com.usingjwttokens.example.tokenbased.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class Logincontrol {
    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    StatusOfResetPasswordService statusOfResetPasswordService;
    @RequestMapping(value="/frgtPwd/{mobileNo}", method =RequestMethod.GET)
    public ResponseEntity<?> findme(@PathVariable(value = "mobileNo",required = false) String mobile) {
        Mail mail = new Mail();
        User userDao = userService.getEmail(mobile);
        String sendMail = userDao.getEmail();
        mail.setMailFrom("sender@gmail.com");
        mail.setMailTo(sendMail);
        mail.setMailSubject("Reset Password");
        mail.setMailContent("To reset your password, please click here : "
                + "http://localhost:4200/reset");
        mailService.sendEmail(mail);
        return ResponseEntity.ok(new MessageResponse("Mail Sent Succesully"));
    }

    @RequestMapping(value="/saveNewPwd" ,method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody ValidatePasswordObject validatePasswordObject) {
        User detailsFromRepo = userService.getUserDetails(validatePasswordObject.getMobileNo());
      //  User userDao = new User();
        User user = new User(detailsFromRepo.getUsername(),
                detailsFromRepo.getEmail(), detailsFromRepo.getFirstname(),
                encoder.encode(validatePasswordObject.getPassword()),"h");
        if (detailsFromRepo != null) {
            detailsFromRepo.setPassword(user.getPassword());
            userService.save(detailsFromRepo);
        }
        StatusOfResetPassword statusOfResetPassword = statusOfResetPasswordService.findUserByMobileNo(validatePasswordObject.getMobileNo());
        if(statusOfResetPassword != null){
            statusOfResetPassword.setStatus(true);
            statusOfResetPasswordService.save(statusOfResetPassword);
        }
        return ResponseEntity.ok(new MessageResponse("Password Changed"));
    }

}

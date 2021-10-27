package com.usingjwttokens.example.tokenbased.repository;

import com.usingjwttokens.example.tokenbased.models.StatusOfResetPassword;
import com.usingjwttokens.example.tokenbased.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusOfResetPasswordRepo extends JpaRepository<StatusOfResetPassword, Long> {

    @Query("SELECT u FROM StatusOfResetPassword u WHERE u.userName = :mobile")
    StatusOfResetPassword findUserByMobile(String mobile);
//select first_name, last_name from Users u where u.user_id =:userId", nativ
    @Query("SELECT userName FROM StatusOfResetPassword u WHERE u.status = 1")
    List<String> getAllStatus();
}

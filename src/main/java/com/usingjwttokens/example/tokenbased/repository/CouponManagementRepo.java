package com.usingjwttokens.example.tokenbased.repository;


import com.usingjwttokens.example.tokenbased.models.CouponManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponManagementRepo extends JpaRepository<CouponManagement, Long> {
    @Query("SELECT c FROM CouponManagement c WHERE c.status = 'Active'")
    List<CouponManagement> getCouponsNotExpired();
}

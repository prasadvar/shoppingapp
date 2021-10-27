package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.CouponManagement;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CouponManagementService {
    public List<CouponManagement> getAll();

    public void save(CouponManagement couponManagement);

    List<CouponManagement> getCouponsNotExpired();
}

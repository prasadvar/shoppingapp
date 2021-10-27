package com.usingjwttokens.example.tokenbased.service;

import com.usingjwttokens.example.tokenbased.models.CouponManagement;
import com.usingjwttokens.example.tokenbased.repository.CouponManagementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponManagementServiceImpl implements CouponManagementService {

    @Autowired
    CouponManagementRepo couponManagementRepo;

    public List<CouponManagement> getAll(){
      return  couponManagementRepo.findAll();
    }
    public  void save(CouponManagement couponManagement){
        couponManagementRepo.save(couponManagement);
    }
    public  List<CouponManagement> getCouponsNotExpired(){
      return   couponManagementRepo.getCouponsNotExpired();
    }
}

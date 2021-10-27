package com.usingjwttokens.example.tokenbased.controllers;

import com.usingjwttokens.example.tokenbased.models.CouponManagement;
import com.usingjwttokens.example.tokenbased.service.CouponManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/coupon")
public class CouponManagementController {

    @Autowired
    CouponManagementService couponManagementService;

//    @GetMapping("/couponDetails")
//    public List<CouponManagement> getAllCouponData() {
//        return couponManagementService.getAll();
//    }

    @PostMapping("/saveCouponData")
    public String saveCouponData(@RequestBody CouponManagement couponManagement) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(
                    "dd-MM-yyyy");


                Date start_date=new SimpleDateFormat("yyyy-MM-dd").parse(couponManagement.getStartDate());
                Date end_date=new SimpleDateFormat("yyyy-MM-dd").parse(couponManagement.getEndDate());
                /*if(start_date.after(end_date)){
                    System.out.println("Date1 is after Date2");
                }*/
              /*  if(start_date.before(end_date)){
                   return "check start and end date";
                }*/
                if(!start_date.after(end_date) || start_date.equals(end_date)){
                Date startDate = sdf.parse(couponManagement.getStartDate());
                Date endDate = sdf.parse(couponManagement.getEndDate());
                long difference_In_Time
                        = endDate.getTime() - startDate.getTime();
                long difference_In_Days
                        = (difference_In_Time
                        / (1000 * 60 * 60 * 24))
                        % 365;
                if(difference_In_Days > 0){
                    couponManagement.setStatus("Active");
                }else{
                    couponManagement.setStatus("Expired");
                }
                couponManagementService.save(couponManagement);
           //     return "Success";
            }
            else {
                return "check dates";
                }
        } catch (Exception e) {

        }
        return "Success";
    }
    @GetMapping("/sendCouponDetailsForadmin")
    public List<CouponManagement> sendCouponDetailsForadmin() {
        return couponManagementService.getAll();
    }
    @GetMapping("/sendCouponDetailsForUser")
    public List<CouponManagement> sendCouponDetailsForUser() {
        return couponManagementService.getCouponsNotExpired();
    }

}

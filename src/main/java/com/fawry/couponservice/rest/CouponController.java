package com.fawry.couponservice.rest;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    private CouponService couponService;
    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }
//    Get all coupons
    @GetMapping
    public List<CouponResponseDto> getAllCoupons(){
        List<CouponResponseDto> coupons = couponService.getCoupons();
        return coupons;
    }
//    create a coupon
    @PostMapping
    public void addCoupon(@RequestBody CouponRequestDto coupon){
       couponService.create(coupon);
//       return createdCoupon;
    }


    @GetMapping("/{identifier}")
        public CouponResponseDto getCouponByIdOrCode(@PathVariable String identifier) {
            // Determine if the identifier is a Long (ID) or a String (Code)
        CouponResponseDto couponOpt;
        try {
                Long id = Long.parseLong(identifier);
                 couponOpt = couponService.getCoupon(id, null);

            } catch (NumberFormatException e) {
                 couponOpt = couponService.getCoupon(null, identifier);
            }
            return  couponOpt;
        }
}

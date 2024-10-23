package com.fawry.couponservice.rest;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.exception.CustomExceptionHandler.NotFoundException;
import com.fawry.couponservice.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if(coupons.isEmpty()){
            throw new NotFoundException("No coupons available");
        }
        return coupons;
    }
    //    create a coupon
    @PostMapping
    public void addCoupon(@RequestBody CouponRequestDto coupon){
        couponService.create(coupon);
    }
    //    get single coupon
    @GetMapping("/{identifier}")
    public CouponResponseDto getCouponByIdOrCode(@PathVariable String identifier) {
        // Determine if the identifier is a Long (ID) or a String (Code)
        CouponResponseDto coupon;
        try {
            Long id = Long.parseLong(identifier);
            coupon = couponService.getCoupon(id, null);

        } catch (NumberFormatException e) {
            coupon = couponService.getCoupon(null, identifier);
        }
        if(coupon == null){
            throw new NotFoundException("Coupon with identifier " + identifier + " not found");
        }
        return  coupon;
    }

    @PutMapping
    public CouponResponseDto updateCoupon(@RequestBody CouponRequestDto coupon){
    return  couponService.update(coupon);
    }
    @DeleteMapping("/{identifier}")
    public void deleteCouponByIdOrCode(@PathVariable String identifier) {

        try {
            Long id = Long.parseLong(identifier);
            couponService.delete(id, null);

        } catch (NumberFormatException e) {
            couponService.delete(null, identifier);
        }
    }
}

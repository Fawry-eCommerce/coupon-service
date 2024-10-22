package com.fawry.couponservice.service;

import com.fawry.couponservice.entity.Coupon;

import java.util.List;

public interface CouponService {
    Coupon create(Coupon coupon);
    Coupon update(Coupon coupon);
    Coupon delete(Long id);
    List<Coupon> getCoupons();
    Coupon getCoupon(Long id);
    Coupon getCouponByCode(String code);
    void useCoupon(Long id);
    Coupon toggleActivation(Long id);
}

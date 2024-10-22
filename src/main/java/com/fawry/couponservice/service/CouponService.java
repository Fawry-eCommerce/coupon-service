package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;

import java.util.List;

public interface CouponService {
    void create(CouponRequestDto coupon);
    List<CouponResponseDto> getCoupons();
    Coupon update(Coupon coupon);
    Coupon delete(Long id);
    Coupon getCoupon(Long id);
    Coupon getCouponByCode(String code);
    void useCoupon(Long id);
    Coupon toggleActivation(Long id);
}

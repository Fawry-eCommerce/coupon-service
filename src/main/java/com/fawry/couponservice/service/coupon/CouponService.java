package com.fawry.couponservice.service.coupon;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;

import java.util.List;

public interface CouponService {
    CouponResponseDto create(CouponRequestDto coupon);
    List<CouponResponseDto> getCoupons();
    CouponResponseDto getCoupon(Long id,String code);
    void delete(Long id,String code);
    CouponResponseDto update(CouponRequestDto coupon);
    void useCoupon(CouponUseDto coupon);
    Coupon toggleActivation(Long id);
}

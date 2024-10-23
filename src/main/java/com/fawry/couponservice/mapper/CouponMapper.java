package com.fawry.couponservice.mapper;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;
import org.springframework.stereotype.Component;


public interface CouponMapper {
    Coupon toEntity(CouponRequestDto couponRequestDto);
    CouponResponseDto toResponse(Coupon coupon);

}

package com.fawry.couponservice.mapper;

import com.fawry.couponservice.dto.ConsumptionRequestDto;
import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.entity.CouponConsumption;

public interface ConsumptionMapper {
    public CouponConsumption toEntity(CouponUseDto consumptionRequestDto, Coupon coupon);
    public ConsumptionResponseDto toResponse(CouponConsumption couponConsumption);
}

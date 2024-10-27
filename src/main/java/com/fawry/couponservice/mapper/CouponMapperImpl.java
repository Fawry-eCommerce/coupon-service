package com.fawry.couponservice.mapper;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponMapperImpl implements CouponMapper {


    @Override
    public CouponResponseDto toResponse(Coupon coupon) {
        return CouponResponseDto.builder()
                .code(coupon.getCode())
                .value(coupon.getValue())
                .active(coupon.isActive())
                .percentage(coupon.isPercentage())
                .remainingUsages(coupon.getRemainingUsages())
                .build();
    }

    @Override
    public Coupon toEntity(CouponRequestDto couponRequestDto) {
        return Coupon.builder()
                .code(couponRequestDto.getCode())
                .value(couponRequestDto.getValue())
                .active(couponRequestDto.isActive())
                .usages(couponRequestDto.getUsages())
                .remainingUsages(couponRequestDto.getUsages())
                .percentage(couponRequestDto.isPercentage())
                .build();
    }
}


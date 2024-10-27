package com.fawry.couponservice.mapper;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.entity.CouponConsumption;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@RequiredArgsConstructor
public class ConsumptionMapperImpl implements ConsumptionMapper {

    private final CouponMapper couponMapper;

    @Override
    public CouponConsumption toEntity(CouponUseDto couponUseDto, Coupon tempCoupon) {
        return CouponConsumption.builder()
                .orderId(couponUseDto.getOrderId())
                .userEmail(couponUseDto.getEmail())
                .coupon(tempCoupon).build();
    }

    @Override
    public ConsumptionResponseDto toResponse(CouponConsumption couponConsumption) {

        return ConsumptionResponseDto.builder()
                .email(couponConsumption.getUserEmail())
                .coupon(couponMapper.toResponse(couponConsumption.getCoupon()))
                .orderId(couponConsumption.getOrderId())
                .build();
    }
}

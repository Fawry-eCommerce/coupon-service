package com.fawry.couponservice.mapper;

import com.fawry.couponservice.dto.ConsumptionRequestDto;
import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.entity.CouponConsumption;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Component
public class ConsumptionMapperImpl implements ConsumptionMapper {
    @Override
    public CouponConsumption toEntity(CouponUseDto couponUseDto, Coupon tempCoupon) {
        return CouponConsumption.builder()
                .orderId(couponUseDto.getOrderId())
                .userEmail(couponUseDto.getEmail())
                .coupon(tempCoupon).build();
    }

    @Override
    public ConsumptionResponseDto toResponse(CouponConsumption couponConsumption) {
        System.out.println(couponConsumption.toString());
        return null;
    }
}
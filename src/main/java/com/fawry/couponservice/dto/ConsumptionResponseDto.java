package com.fawry.couponservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionResponseDto {
    private String email;
    private Long orderId;
    private CouponResponseDto coupon;
    private Timestamp createdAt;
}

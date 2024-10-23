package com.fawry.couponservice.dto;

import com.fawry.couponservice.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionRequestDto {
    private String email;
    private Long orderId;
    private Coupon coupon;
    private Timestamp createdAt;
}
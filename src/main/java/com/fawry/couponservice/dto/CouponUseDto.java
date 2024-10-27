package com.fawry.couponservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponUseDto {
    private String email;
    private String code;
    private Long orderId;
}
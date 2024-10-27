package com.fawry.couponservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequestDto {
    private String code;
    private int value;
    private boolean active;
    private boolean percentage;
    private int usages;
}

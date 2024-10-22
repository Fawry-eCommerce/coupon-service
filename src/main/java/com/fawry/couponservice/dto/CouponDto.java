package com.fawry.couponservice.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CouponDto {
    private Long id;
    private String code;
    private int value;
    private boolean isActive;
    private boolean isPercentage;
}

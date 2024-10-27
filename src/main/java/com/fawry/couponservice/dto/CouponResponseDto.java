package com.fawry.couponservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponResponseDto {
    private String code;
    private int value;
    private boolean active;
    private boolean percentage;
    private int usages;
    private Timestamp expiredAt;
    private int remainingUsages;

}

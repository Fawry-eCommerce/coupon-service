package com.fawry.couponservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequestDto {
    private String code;
    private int value;
    private boolean isActive;
    private boolean isPercentage;
    private int usages;
    public boolean getIsPercentage() {
        return isPercentage;
    }

}

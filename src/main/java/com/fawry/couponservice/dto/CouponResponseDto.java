package com.fawry.couponservice.dto;

import jakarta.persistence.*;
import lombok.*;

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

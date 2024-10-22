package com.fawry.couponservice.dto;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponResponseDto {
        private String code;
        private int value;
        private boolean isActive;
        private boolean isPercentage;
        private int usages;
        private Timestamp expiredAt;
        private int remainingUsages;

        public boolean isActive() {
                return isActive;
        }

        public void setActive(boolean active) {
                isActive = active;
        }

        public boolean isPercentage() {
                return isPercentage;
        }

        public void setPercentage(boolean percentage) {
                isPercentage = percentage;
        }
}

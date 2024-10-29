package com.fawry.couponservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequestDto {
    @NotBlank(message = "Code is mandatory")
    private String code;
    @NotNull(message = "coupon price is mandatory")
    private int value;
    private boolean active = true;
    @NotNull(message = "please determine if the coupon is a percentage or not")
    private boolean percentage;
    @NotNull(message = "please determine the number of usages")
    private int usages;
}

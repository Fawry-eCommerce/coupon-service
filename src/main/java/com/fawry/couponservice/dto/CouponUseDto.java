package com.fawry.couponservice.dto;

import jakarta.validation.constraints.Email;
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
public class CouponUseDto {
    @Email(message = "email should be valid")
    @NotBlank(message = "email is mandatory")
    private String email;
    @NotBlank(message = "code is mandatory")
    private String code;
    @NotNull(message = "order id is mandatory")
    private Long orderId;
}
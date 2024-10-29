package com.fawry.couponservice.rest;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.service.couponconsumption.CouponConsumptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("coupons-history")
@RequiredArgsConstructor
public class CouponConsumptionController {
    
    private final CouponConsumptionService couponConsumptionService;

    @GetMapping("/{couponCode}")
    public List<ConsumptionResponseDto> getCouponHistory(@PathVariable String couponCode) {
        return couponConsumptionService.getCouponHistory(couponCode);
    }

    @GetMapping("/user/{userEmail}")
    public List<ConsumptionResponseDto> getCouponsUsedByUser(@PathVariable String userEmail) {
        return couponConsumptionService.getCouponsHistoryUsedByUser(userEmail);
    }

}

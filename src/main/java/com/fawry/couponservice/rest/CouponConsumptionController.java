package com.fawry.couponservice.rest;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.entity.CouponConsumption;
import com.fawry.couponservice.service.CouponConsumptionService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coupons-history")
public class CouponConsumptionController {
    private final CouponConsumptionService couponConsumptionService;
    public CouponConsumptionController(CouponConsumptionService couponConsumptionService) {
        this.couponConsumptionService = couponConsumptionService;
    }

    @GetMapping("/{couponCode}")
    public List<ConsumptionResponseDto> getCouponHistory(@PathVariable String couponCode) {
      return  couponConsumptionService.getCouponHistory(couponCode);
    }

}

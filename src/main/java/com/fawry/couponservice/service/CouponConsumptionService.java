package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.ConsumptionRequestDto;
import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;

import java.util.List;

public interface CouponConsumptionService {
    List<ConsumptionResponseDto> getCouponHistory(String code);
    List<ConsumptionResponseDto> getCouponsHistoryUsedByUser(String userEmail);


}

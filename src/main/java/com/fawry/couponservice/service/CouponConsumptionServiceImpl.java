package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.entity.CouponConsumption;
import com.fawry.couponservice.mapper.ConsumptionMapper;
import com.fawry.couponservice.repository.CouponConsumptionsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponConsumptionServiceImpl implements CouponConsumptionService{
    private final CouponConsumptionsRepository repository;
    private final ConsumptionMapper mapper ;

    @Autowired
    public CouponConsumptionServiceImpl(CouponConsumptionsRepository repository, ConsumptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ConsumptionResponseDto> getCouponHistory(String code) {
       List<CouponConsumption> history =repository.findByCouponCode(code);
       mapper.toResponse(history.get(0));
        return List.of();
    }

    @Override
    public List<ConsumptionResponseDto> getCouponsUsedByUser(Long userId) {
        return List.of();
    }
}

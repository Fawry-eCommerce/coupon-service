package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.dto.CouponResponseDto;
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
       return history.stream().map(couponConsumption -> mapper.toResponse(couponConsumption)).toList();
    }

    @Override
    public List<ConsumptionResponseDto> getCouponsHistoryUsedByUser(String userEmail) {
        List<CouponConsumption> history =repository.findByUserEmail(userEmail);
        System.out.println(history.size());
        return history.stream().map(couponConsumption -> mapper.toResponse(couponConsumption)).toList();
    }
}

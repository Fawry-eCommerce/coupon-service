package com.fawry.couponservice.service.couponconsumption;

import com.fawry.couponservice.dto.ConsumptionResponseDto;
import com.fawry.couponservice.entity.CouponConsumption;
import com.fawry.couponservice.mapper.ConsumptionMapper;
import com.fawry.couponservice.repository.CouponConsumptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponConsumptionServiceImpl implements CouponConsumptionService {

    private final CouponConsumptionsRepository repository;
    private final ConsumptionMapper mapper;

    @Override
    public List<ConsumptionResponseDto> getCouponHistory(String code) {
        List<CouponConsumption> history = repository.findByCouponCode(code);
        return history.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ConsumptionResponseDto> getCouponsHistoryUsedByUser(String userEmail) {
        List<CouponConsumption> history = repository.findByUserEmail(userEmail);
        System.out.println(history.size());
        return history.stream()
                .map(mapper::toResponse)
                .toList();
    }
}

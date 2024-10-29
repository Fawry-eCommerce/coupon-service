package com.fawry.couponservice.service.coupon;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.entity.CouponConsumption;
import com.fawry.couponservice.mapper.ConsumptionMapper;
import com.fawry.couponservice.mapper.CouponMapper;
import com.fawry.couponservice.repository.CouponConsumptionsRepository;
import com.fawry.couponservice.repository.CouponRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponConsumptionsRepository couponConsumptionsRepository;
    private final CouponMapper couponMapper;
    private final ConsumptionMapper consumptionMapper;

    @Override
    public CouponResponseDto create(CouponRequestDto coupon) {
        if (isCouponCodeExists(coupon.getCode())) {
            throw new IllegalArgumentException("Coupon with code already exists");
        }
        Coupon createdCoupon = couponMapper.toEntity(coupon);
        couponRepository.save(createdCoupon);
        return couponMapper.toResponse(createdCoupon);
    }

    @Override
    public List<CouponResponseDto> getCoupons() {
        return couponRepository.findAll().stream()
                .map(couponMapper::toResponse)
                .toList();
    }

    @Override
    public CouponResponseDto getCoupon(Long id, String code) {
        Coupon coupon = findCouponByIdOrCode(id, code);
        return couponMapper.toResponse(coupon);
    }

    @Override
    @Transactional
    public CouponResponseDto update(CouponRequestDto coupon) {
        Coupon existingCoupon = findCouponByCode(coupon.getCode());
        updateCouponDetails(existingCoupon, coupon);
        couponRepository.save(existingCoupon);
        return couponMapper.toResponse(existingCoupon);
    }

    @Override
    public void delete(Long id, String code) {
        Coupon coupon = findCouponByIdOrCode(id, code);
        couponRepository.delete(coupon);
    }

    @Override
    public void useCoupon(CouponUseDto coupon) {
        Coupon existingCoupon = findCouponByCode(coupon.getCode());
        if (existingCoupon.isActive() && existingCoupon.getRemainingUsages() > 0) {
            existingCoupon.setRemainingUsages(existingCoupon.getRemainingUsages() - 1);
            couponRepository.save(existingCoupon);
            CouponConsumption couponConsumption = consumptionMapper.toEntity(coupon, existingCoupon);
            couponConsumptionsRepository.save(couponConsumption);
        }
    }

    @Override
    public Coupon toggleActivation(Long id) {
        return null;
    }

    private boolean isCouponCodeExists(String code) {
        return couponRepository.existsByCode(code);
    }

    private Coupon findCouponByIdOrCode(Long id, String code) {
        return id != null ? couponRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Coupon with identifier not found"))
                : couponRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Coupon with identifier not found"));
    }

    private Coupon findCouponByCode(String code) {
        return couponRepository.findByCode(code).orElseThrow(
                () -> new EntityNotFoundException("Coupon with identifier not found")
        );
    }

    private void updateCouponDetails(Coupon existingCoupon, CouponRequestDto coupon) {
        existingCoupon.setActive(coupon.isActive());
        existingCoupon.setCode(coupon.getCode());
        existingCoupon.setUsages(existingCoupon.getUsages() + coupon.getUsages());
        existingCoupon.setValue(coupon.getValue());
        existingCoupon.setPercentage(coupon.isPercentage());
        existingCoupon.setRemainingUsages(existingCoupon.getRemainingUsages() + coupon.getUsages());
    }
}
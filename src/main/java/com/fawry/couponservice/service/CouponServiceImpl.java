package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.repository.CouponRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository;
    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }
//    ----------------------------------------------------------
    @Override
    public void create(CouponRequestDto coupon) {
//        create a coupon entity to be saved to the database
        Coupon couponEntity = new Coupon();
        couponEntity.setCode(coupon.getCode());
        couponEntity.setActive(coupon.isActive());
        couponEntity.setUsages(coupon.getUsages());
        couponEntity.setValue(coupon.getValue());
        couponEntity.setPercentage(coupon.getIsPercentage());
        couponRepository.save(couponEntity);
    }
//    ----------------------------------------------------------
    @Override
    public List<CouponResponseDto> getCoupons() {
        List<Coupon> coupons = couponRepository.findAll(); // data as entity
      return   coupons.stream().map(coupon -> new CouponResponseDto(coupon.getCode(),
              coupon.getValue(),
              coupon.isActive(),
              coupon.isPercentage(),
              coupon.getUsages(),
              coupon.getExpiredAt(),
              coupon.getRemainingUsages()))
              .toList();

    }

    @Override
    public Coupon update(Coupon coupon) {
        return null;
    }

    @Override
    public Coupon delete(Long id) {
        return null;
    }


    @Override
    public Coupon getCoupon(Long id) {
        return null;
    }

    @Override
    public Coupon getCouponByCode(String code) {
        return null;
    }

    @Override
    public void useCoupon(Long id) {

    }

    @Override
    public Coupon toggleActivation(Long id) {
        return null;
    }
}

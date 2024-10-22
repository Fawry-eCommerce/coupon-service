package com.fawry.couponservice.service;

import com.fawry.couponservice.entity.Coupon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Override
    public Coupon create(Coupon coupon) {
        return null;
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
    public List<Coupon> getCoupons() {
        return List.of();
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

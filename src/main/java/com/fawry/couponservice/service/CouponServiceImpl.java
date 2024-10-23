package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.exception.CustomExceptionHandler.NotFoundException;
import com.fawry.couponservice.repository.CouponRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
    public CouponResponseDto getCoupon(Long id,String code) {

        CouponResponseDto couponResponseDto = null;
        Coupon coupon=null;
        if(id!=null){
             coupon = couponRepository.findById(id).orElse(null);
        }
        else if(code!=null){
             coupon = couponRepository.findByCode(code).orElse(null);
        }
        if(coupon!=null){
            couponResponseDto.setActive(coupon.isActive());
            couponResponseDto.setCode(coupon.getCode());
            couponResponseDto.setUsages(coupon.getUsages());
            couponResponseDto.setValue(coupon.getValue());
            couponResponseDto.setPercentage(coupon.isPercentage());
            couponResponseDto.setExpiredAt(coupon.getExpiredAt());
            couponResponseDto.setRemainingUsages(coupon.getRemainingUsages());
        }
        return couponResponseDto;
    }
//----------------------------------------------------------

    @Override
    @Transactional
    public CouponResponseDto update(CouponRequestDto coupon) {

        CouponResponseDto couponResponseDto = new CouponResponseDto();

           Coupon  tempCoupon = couponRepository.findByCode(coupon.getCode()).orElse(null);


        if(tempCoupon!=null){
            tempCoupon.setActive(coupon.isActive());
            tempCoupon.setCode(coupon.getCode());
            tempCoupon.setUsages(coupon.getUsages());
            tempCoupon.setValue(coupon.getValue());
            tempCoupon.setPercentage(coupon.getIsPercentage());
            couponRepository.save(tempCoupon);
//            --------------------------------------------------
            couponResponseDto.setActive(coupon.isActive());
            couponResponseDto.setCode(coupon.getCode());
            couponResponseDto.setUsages(coupon.getUsages());
            couponResponseDto.setValue(coupon.getValue());
            couponResponseDto.setPercentage(coupon.getIsPercentage());
        }else {
            throw new NotFoundException("Coupon not found for code: " + coupon.getCode());
        }
        return couponResponseDto;
    }

    @Override
    public void delete(Long id,String code) {
        Coupon coupon=null;
        if(id!=null){
            coupon = couponRepository.findById(id).orElse(null);
        }
        else if(code!=null){
            coupon = couponRepository.findByCode(code).orElse(null);
        }
       if(coupon==null){
           throw new NotFoundException("Coupon with identifier not found so can't be deleted");
       }
        couponRepository.delete(coupon);

    }




    @Override
    public void useCoupon(Long id) {

    }

    @Override
    public Coupon toggleActivation(Long id) {
        return null;
    }
}

package com.fawry.couponservice.service;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.entity.Coupon;
import com.fawry.couponservice.entity.CouponConsumption;
import com.fawry.couponservice.exception.CustomExceptionHandler.NotFoundException;
import com.fawry.couponservice.mapper.ConsumptionMapper;
import com.fawry.couponservice.mapper.CouponMapper;
import com.fawry.couponservice.repository.CouponConsumptionsRepository;
import com.fawry.couponservice.repository.CouponRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository;
    private CouponConsumptionsRepository couponConsumptionsRepository;
    private CouponMapper couponMapper;
    private ConsumptionMapper consumptionMapper;
//    private

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository,CouponMapper couponMapper,CouponConsumptionsRepository couponConsumptionsRepository,ConsumptionMapper consumptionMapper) {
        this.couponRepository = couponRepository;
        this.couponMapper=couponMapper;
        this.couponConsumptionsRepository=couponConsumptionsRepository;
        this.consumptionMapper=consumptionMapper;
    }
//    ----------------------------------------------------------
    @Override
    public void create(CouponRequestDto coupon) {
//        create a coupon entity to be saved to the database

       Coupon createdCoupon = couponMapper.toEntity(coupon);
        couponRepository.save(createdCoupon);
    }
//    ----------------------------------------------------------
    @Override
    public List<CouponResponseDto> getCoupons() {
        List<Coupon> coupons = couponRepository.findAll(); // data as entity
      return   coupons.stream().map(coupon -> couponMapper.toResponse(coupon)).toList();
    }
    //    ----------------------------------------------------------

    @Override
    public CouponResponseDto getCoupon(Long id,String code) {

        Coupon coupon=null;
        if(id!=null){
             coupon = couponRepository.findById(id).orElse(null);
        }
        else if(code!=null){
             coupon = couponRepository.findByCode(code).orElse(null);
        }
        if(coupon!=null){
            CouponResponseDto couponResponseDto = couponMapper.toResponse(coupon);
            return couponResponseDto;
        }
        return null;
    }
//----------------------------------------------------------

    @Override
    @Transactional
    public CouponResponseDto update(CouponRequestDto coupon) {
                   Coupon  tempCoupon = couponRepository.findByCode(coupon.getCode()).orElse(null);
        if(tempCoupon!=null){
            tempCoupon.setActive(coupon.isActive());
            tempCoupon.setCode(coupon.getCode());
            tempCoupon.setUsages(coupon.getUsages());
            tempCoupon.setValue(coupon.getValue());
            tempCoupon.setPercentage(coupon.isPercentage());
            couponRepository.save(tempCoupon);
//            --------------------------------------------------

            CouponResponseDto couponResponseDto = couponMapper.toResponse(tempCoupon);
            return couponResponseDto;

        }
        else {
            throw new NotFoundException("Coupon not found for code: " + coupon.getCode());
        }
    }
    //    ----------------------------------------------------------

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
//    ----------------------------------------------------------

    @Override
    public void useCoupon(CouponUseDto coupon) {
//        find coupon
        Coupon tempCoupon = couponRepository.findByCode(coupon.getCode()).orElse(null);

//        validate it is valid to use
        if(tempCoupon!=null){
            if(tempCoupon.isActive()&&tempCoupon.getRemainingUsages()>0){
//       consume coupon here and update the coupon after finishing
                tempCoupon.setRemainingUsages(tempCoupon.getRemainingUsages()-1);
                couponRepository.save(tempCoupon);
//               convert use dto to entity;
                CouponConsumption couponConsumption = consumptionMapper.toEntity(coupon,tempCoupon);
                couponConsumptionsRepository.save(couponConsumption);
            }
        }
    }

    @Override
    public Coupon toggleActivation(Long id) {
        return null;
    }
}

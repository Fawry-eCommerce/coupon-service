package com.fawry.couponservice.rest;

import com.fawry.couponservice.dto.CouponRequestDto;
import com.fawry.couponservice.dto.CouponResponseDto;
import com.fawry.couponservice.dto.CouponUseDto;
import com.fawry.couponservice.service.coupon.CouponService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    public List<CouponResponseDto> getAllCoupons() {
        return couponService.getCoupons();
    }

    @PostMapping
    public CouponResponseDto addCoupon(@Valid @RequestBody CouponRequestDto coupon) {
        return couponService.create(coupon);
    }

    @GetMapping("{identifier}")
    public CouponResponseDto getCouponByIdOrCode(@PathVariable String identifier) {
        return findCouponByIdentifier(identifier);
    }

    @PostMapping("use-coupon")
    public void useCoupon(@Valid @RequestBody CouponUseDto coupon) {
        couponService.useCoupon(coupon);
    }

    @PutMapping
    public CouponResponseDto updateCoupon(@Valid @RequestBody CouponRequestDto coupon) {
        return couponService.update(coupon);
    }

    @DeleteMapping("{identifier}")
    public void deleteCouponByIdOrCode(@PathVariable String identifier) {
        deleteCouponByIdentifier(identifier);
    }

    private CouponResponseDto findCouponByIdentifier(String identifier) {
        try {
            Long id = Long.parseLong(identifier);
            return couponService.getCoupon(id, null);
        } catch (NumberFormatException e) {
            return couponService.getCoupon(null, identifier);
        }
    }

    private void deleteCouponByIdentifier(String identifier) {
        try {
            Long id = Long.parseLong(identifier);
            couponService.delete(id, null);
        } catch (NumberFormatException e) {
            couponService.delete(null, identifier);
        }
    }
}
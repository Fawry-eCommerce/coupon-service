package com.fawry.couponservice.repository;

import com.fawry.couponservice.entity.CouponConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponConsumptionsRepository extends JpaRepository<CouponConsumption, Long> {
    @Query("SELECT cc FROM CouponConsumption cc JOIN cc.coupon c WHERE c.code = :couponCode")
    List<CouponConsumption> findByCouponCode(@Param("couponCode") String couponCode);

}

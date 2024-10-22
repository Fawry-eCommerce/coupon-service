package com.fawry.couponservice.repository;

import com.fawry.couponservice.entity.CouponConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponConsumptionsRepository extends JpaRepository<CouponConsumption, Long> {
}

package com.fawry.couponservice.repository;

import com.fawry.couponservice.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {
    @Query("SELECT c FROM Coupon c WHERE c.code = :code")
    Optional<Coupon> findByCode(@Param("code") String code);

}
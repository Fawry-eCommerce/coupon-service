package com.fawry.couponservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "coupon_consumption")
public class CouponConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "actual_discount")
    private Double actualDiscount;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}

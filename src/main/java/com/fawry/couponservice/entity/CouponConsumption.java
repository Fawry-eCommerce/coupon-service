package com.fawry.couponservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Timestamp createdAt;
}

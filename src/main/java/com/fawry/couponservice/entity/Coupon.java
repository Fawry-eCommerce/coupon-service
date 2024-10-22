package com.fawry.couponservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "coupon")
public class Coupon {
//    fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(unique = true, name = "code")
    private String code;
    @Column(name = "remaining_usages")
    private int remainingUsages;
    @Column(name = "usages")
    private int usages;
    @Column(name = "value")
    private int value;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_percentage")
    private boolean isPercentage;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "expired_at")
    private Date expiredAt;
    @OneToMany(mappedBy = "coupon",cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}
    )
    private List<CouponConsumption> couponConsumptionList;
}

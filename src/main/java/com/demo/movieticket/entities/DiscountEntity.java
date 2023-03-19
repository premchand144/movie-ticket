package com.demo.movieticket.entities;

import com.demo.movieticket.enums.DiscountType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DISCOUNT")
@Data
public class DiscountEntity extends BaseEntity {

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "theater_id")
    private Integer theaterId;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    private DiscountType discountType;
}

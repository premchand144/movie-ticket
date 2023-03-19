package com.demo.movieticket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table(name = "SHOW_TIMING")
public class ShowTimingEntity extends BaseEntity {

    @Temporal(TemporalType.TIME)
    @Column(name = "show_time")
    private LocalTime showTime;
}

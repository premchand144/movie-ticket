package com.demo.movieticket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "THEATER_SHOW_TIMING")
public class TheaterShowEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private TheaterEntity theater;

    @Column(name = "show_timing_id")
    private Integer showTimingId;

    @Temporal(TemporalType.DATE)
    @Column(name = "show_date")
    private LocalDate showDate;

}

package com.demo.movieticket.entities;

import com.demo.movieticket.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "THEATER_SEAT")
@Data
public class TheaterSeatEntity extends BaseEntity {

    @Column(name = "seat_row")
    private String seatRow;
    @Column(name = "seat_col")
    private Integer seatCol;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")
    private SeatType seatType;
    private Double price;

    @ManyToOne()
    @JoinColumn(name = "theater_id")
    private TheaterEntity theater;
}

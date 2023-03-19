package com.demo.movieticket.rest.dtos;

import com.demo.movieticket.enums.SeatType;
import lombok.Data;

@Data
public class TheaterSeatDto {

    private String row;
    private Integer col;
    private SeatType seatType;
}

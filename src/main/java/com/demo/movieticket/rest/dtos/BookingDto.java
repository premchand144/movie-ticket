package com.demo.movieticket.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto {

    private String bookingNumber;
    private Integer noOfSeats;
    private Integer theaterId;
    private Integer cityId;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<TheaterSeatDto> seats;
}

package com.demo.movieticket.services;

import com.demo.movieticket.entities.TheaterSeatEntity;
import com.demo.movieticket.rest.dtos.BookingDto;

import java.util.List;

public interface DiscountService {

    double calculateDiscount(BookingDto bookingDto, List<TheaterSeatEntity> theaterSeats);
}

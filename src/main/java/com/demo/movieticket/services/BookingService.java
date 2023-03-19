package com.demo.movieticket.services;

import com.demo.movieticket.rest.dtos.BookingDto;

public interface BookingService {

    BookingDto bookTicket(BookingDto bookingDto);
}

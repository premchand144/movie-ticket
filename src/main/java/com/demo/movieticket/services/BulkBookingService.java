package com.demo.movieticket.services;

import com.demo.movieticket.rest.dtos.BookingDto;

import java.util.List;

public interface BulkBookingService {

    void bookBulkTickets(List<BookingDto> bookingDtos);
    void bulkCancelTickets(List<BookingDto> bookingDtos);
}

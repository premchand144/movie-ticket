package com.demo.movieticket.services.impl;

import com.demo.movieticket.entities.BookingEntity;
import com.demo.movieticket.entities.TheaterEntity;
import com.demo.movieticket.entities.TheaterSeatEntity;
import com.demo.movieticket.enums.BookingStatus;
import com.demo.movieticket.repositories.BookingRepository;
import com.demo.movieticket.repositories.TheaterSeatRepository;
import com.demo.movieticket.rest.dtos.BookingDto;
import com.demo.movieticket.services.BookingService;
import com.demo.movieticket.services.DiscountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    @Autowired
    private DiscountService discountService;

    @Transactional
    @Override
    public BookingDto bookTicket(BookingDto bookingDto) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setNoOfSeats(bookingDto.getNoOfSeats());
        bookingEntity.setShowDate(bookingDto.getShowDate());
        bookingEntity.setStatus(BookingStatus.REQUESTED);
        bookingEntity.setShowTime(bookingDto.getShowTime());

        TheaterEntity theater = new TheaterEntity();
        theater.setId(bookingDto.getTheaterId());
        bookingEntity.setTheater(theater);

        List<TheaterSeatEntity> theaterSeats = bookingDto.getSeats().stream().map(seat ->
                        theaterSeatRepository.getPriceBySeatRowAndSeatColAndSeatTypeAndTheater(seat.getRow(),
                                seat.getCol(), seat.getSeatType(), theater)).collect(Collectors.toList());

        double totalAmount = theaterSeats.stream().mapToDouble(TheaterSeatEntity::getPrice).sum();
        double totalDiscount = discountService.calculateDiscount(bookingDto, theaterSeats);

        log.info("Total Amount to be paid: " + totalAmount);
        log.info("Total Discount calculated: " + totalDiscount);

        bookingEntity.setStatus(BookingStatus.CONFIRMED);
        bookingEntity.setBookedSeats(theaterSeats);
        BookingEntity save = bookingRepository.save(bookingEntity);
        bookingDto.setBookingNumber(save.getBookingNumber());
        return bookingDto;
    }
}

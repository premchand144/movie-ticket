package com.demo.movieticket.services.impl;

import com.demo.movieticket.entities.BookingEntity;
import com.demo.movieticket.entities.TheaterEntity;
import com.demo.movieticket.entities.TheaterSeatEntity;
import com.demo.movieticket.enums.BookingStatus;
import com.demo.movieticket.repositories.BookingRepository;
import com.demo.movieticket.repositories.TheaterSeatRepository;
import com.demo.movieticket.rest.dtos.BookingDto;
import com.demo.movieticket.services.BulkBookingService;
import com.demo.movieticket.services.DiscountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BulkBookingServiceImpl implements BulkBookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    @Autowired
    private DiscountService discountService;

    @Transactional
    @Override
    public void bookBulkTickets(List<BookingDto> bookingDtos) {

        try {
            List<BookingEntity> bookingEntities = bookingDtos.stream().map(bookingDto -> {
                BookingEntity bookingEntity = new BookingEntity();
                bookingEntity.setNoOfSeats(bookingDto.getNoOfSeats());
                bookingEntity.setShowDate(bookingDto.getShowDate());
                bookingEntity.setStatus(BookingStatus.REQUESTED);
                bookingEntity.setShowTime(bookingDto.getShowTime());
                bookingEntity.setActive(true);
                bookingEntity.setCreatedAt(LocalDateTime.now());

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

                return bookingEntity;
            }).collect(Collectors.toList());

            bookingRepository.saveAll(bookingEntities);
            log.info("All the tickets booked successfully");
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void bulkCancelTickets(List<BookingDto> bookingDtos) {
        List<String> bookingNumbers = bookingDtos.stream().map(
                BookingDto::getBookingNumber
                ).collect(Collectors.toList());

        bookingRepository.cancelBookingByBookingNumber(bookingNumbers);
        log.info("Successfully cancelled all the bookings");
    }
}

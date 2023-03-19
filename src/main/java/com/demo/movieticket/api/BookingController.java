package com.demo.movieticket.api;

import com.demo.movieticket.rest.dtos.BookingDto;
import com.demo.movieticket.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping()
    public ResponseEntity<BookingDto> bookTicket(@RequestBody BookingDto bookingDto) {
        BookingDto bookingDto1 = bookingService.bookTicket(bookingDto);
        return ResponseEntity.ok(bookingDto1);
    }

}

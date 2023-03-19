package com.demo.movieticket.api;

import com.demo.movieticket.rest.dtos.BookingDto;
import com.demo.movieticket.services.BulkBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/bulk/booking")
public class BulkBookingController {

    @Autowired
    private BulkBookingService bookingService;

    @PostMapping()
    public ResponseEntity<Object> bookTicket(@RequestBody List<BookingDto> bookingDto) {
        bookingService.bookBulkTickets(bookingDto);
        return ResponseEntity.ok("Successfully booked all the tickets");
    }

    @PutMapping()
    public ResponseEntity<Object> CancelTicket(@RequestBody List<BookingDto> bookingDto) {
        bookingService.bulkCancelTickets(bookingDto);
        return ResponseEntity.ok("Successfully cancelled all the tickets");
    }
}

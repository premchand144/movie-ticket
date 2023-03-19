package com.demo.movieticket.entities;

import com.demo.movieticket.enums.BookingStatus;
import com.demo.movieticket.utils.Utils;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "BOOKING")
@Data
public class BookingEntity  {

    @Id
    @Column(name = "booking_number")
    private String bookingNumber;

    @Column(name = "no_of_seats")
    private Integer noOfSeats;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Temporal(TemporalType.DATE)
    @Column(name = "show_date")
    private LocalDate showDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "show_time")
    private LocalTime showTime;

    @OneToOne
    @JoinColumn(name = "theater_id", referencedColumnName = "id")
    private TheaterEntity theater;

    @OneToMany
    @JoinTable(
            name = "BOOKING_SEAT",
            joinColumns = @JoinColumn(name = "booking_number"),
            inverseJoinColumns = @JoinColumn(name = "theater_seat_id")
    )
    private List<TheaterSeatEntity> bookedSeats;

    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time")
    private LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_time")
    private LocalDateTime updatedAt;

    @PrePersist
    private void preBookingNumber() {

        if(!StringUtils.hasLength(bookingNumber)) {
            bookingNumber = Utils.generateUUID(13);
        }
    }
}

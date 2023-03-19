package com.demo.movieticket.repositories;

import com.demo.movieticket.entities.BookingEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

    @Modifying
    @Query(
            value = "update BOOKING set active=false, modified_time=CURRENT_TIMESTAMP where booking_number IN :bookingNumbers",
            nativeQuery = true
    )
    void cancelBookingByBookingNumber(@Param("bookingNumbers") List<String> bookingNumbers);
}

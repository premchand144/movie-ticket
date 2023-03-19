package com.demo.movieticket.repositories;

import com.demo.movieticket.entities.TheaterEntity;
import com.demo.movieticket.entities.TheaterSeatEntity;
import com.demo.movieticket.enums.SeatType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterSeatRepository extends CrudRepository<TheaterSeatEntity, Integer> {

    TheaterSeatEntity getPriceBySeatRowAndSeatColAndSeatTypeAndTheater(String seatRow, Integer seatCol, SeatType seatType, TheaterEntity theater);
}

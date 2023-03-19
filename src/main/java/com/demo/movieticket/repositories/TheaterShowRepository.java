package com.demo.movieticket.repositories;

import com.demo.movieticket.entities.TheaterShowEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TheaterShowRepository extends CrudRepository<TheaterShowEntity, Integer> {

    @Modifying
    @Query(
            value = "delete from THEATER_SHOW_TIMING where theater_id= :theaterId and show_date = :showDate",
            nativeQuery = true
    )
    void deleteShow(@Param("theaterId") Integer theaterId, @Param("showDate") LocalDate showDate);
}

package com.demo.movieticket.repositories;

import com.demo.movieticket.entities.MovieEntity;
import com.demo.movieticket.query.projections.TheaterShowDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {


    @Query(
            value = "select th.id, th.name, th.address, ct.name as city, st.show_time as showtime, th.active from movie m, movie_theater mth, " +
            "theater th, city ct, theater_show_timing thst, show_timing st " +
            "where m.id=mth.movie_id and th.id=mth.theater_id and ct.id=th.city_id " +
            "and th.id=thst.theater_id and st.id=thst.show_timing_id " +
            "and m.id= :movieId and thst.show_date= :showDate and ct.id= :cityId",
            nativeQuery = true
    )
    List<TheaterShowDetails> getTheaterShows(@Param("movieId") Integer movieId, @Param("showDate") LocalDate showDate,
                                             @Param("cityId") Integer cityId);


}

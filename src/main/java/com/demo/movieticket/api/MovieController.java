package com.demo.movieticket.api;

import com.demo.movieticket.rest.dtos.MovieDto;
import com.demo.movieticket.rest.dtos.TheaterDto;
import com.demo.movieticket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/demo/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}/theaters")
    public ResponseEntity<MovieDto> getTheaters(@PathVariable("id") Integer movieId,
                                                    @RequestParam("cityId") Integer cityId, @RequestParam("showDate") LocalDate showDate) {
        Set<TheaterDto> theaterShows = movieService.getTheaters(movieId, showDate, cityId);
        System.out.println("Theaters: " + theaterShows);
        MovieDto movieDto = new MovieDto();
        movieDto.setTheaters(theaterShows);
        return ResponseEntity.ok(movieDto);
    }
}

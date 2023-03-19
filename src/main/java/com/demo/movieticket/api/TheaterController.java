package com.demo.movieticket.api;

import com.demo.movieticket.rest.dtos.ShowTimingDto;
import com.demo.movieticket.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/demo/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/{theaterId}/shows")
    public ResponseEntity<ShowTimingDto> createShow(@RequestBody ShowTimingDto showTimingDto, @PathVariable("theaterId") Integer theaterId) {

        ShowTimingDto shows = theaterService.createShows(theaterId, showTimingDto);

        return ResponseEntity.ok(shows);
    }

    @PutMapping("/{theaterId}/shows")
    public ResponseEntity<ShowTimingDto> updateShow(@RequestBody ShowTimingDto showTimingDto, @PathVariable("theaterId") Integer theaterId) {

        ShowTimingDto shows = theaterService.updateShows(theaterId, showTimingDto);

        return ResponseEntity.ok(shows);
    }

    @DeleteMapping("/{theaterId}/shows/{showDate}")
    public ResponseEntity<Object> deleteShow(@PathVariable("theaterId") Integer theaterId, @PathVariable("showDate") LocalDate showDate) {

        theaterService.deleteShows(theaterId, showDate);

        return ResponseEntity.ok("Shows Successfully Deleted!");
    }
}

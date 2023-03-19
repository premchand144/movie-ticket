package com.demo.movieticket.services;

import com.demo.movieticket.rest.dtos.ShowTimingDto;

import java.time.LocalDate;

public interface TheaterService {

    ShowTimingDto createShows(Integer theaterId, ShowTimingDto showTimingDto);
    ShowTimingDto updateShows(Integer theaterId, ShowTimingDto showTimingDto);

    void deleteShows(Integer theaterId, LocalDate showDate);
}

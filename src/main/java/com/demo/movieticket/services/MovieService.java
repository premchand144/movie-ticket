package com.demo.movieticket.services;

import com.demo.movieticket.rest.dtos.TheaterDto;

import java.time.LocalDate;
import java.util.Set;

public interface MovieService {

    Set<TheaterDto> getTheaters(Integer movieId, LocalDate showDate, Integer cityId);
}

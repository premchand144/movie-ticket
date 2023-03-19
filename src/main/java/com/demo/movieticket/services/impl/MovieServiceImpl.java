package com.demo.movieticket.services.impl;

import com.demo.movieticket.exception.DomainException;
import com.demo.movieticket.query.projections.TheaterShowDetails;
import com.demo.movieticket.repositories.MovieRepository;
import com.demo.movieticket.rest.dtos.TheaterDto;
import com.demo.movieticket.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;



    @Override
    public Set<TheaterDto> getTheaters(Integer movieId, LocalDate showDate, Integer cityId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        try {
            List<TheaterShowDetails> theaterShows = movieRepository.getTheaterShows(movieId, showDate, cityId);

            if(theaterShows.isEmpty())
                throw new Exception("No Record Found!!");

            final Map<Integer, List<TheaterShowDetails>> theaterDetails = theaterShows.stream()
                    .collect(Collectors.groupingBy(TheaterShowDetails::getId));

            final Set<TheaterDto> theaterDtos = new HashSet<>();
            theaterDetails.forEach((key, value) -> {
                final TheaterDto dtos = new TheaterDto();
                dtos.setShowTimes(new HashSet<>());
                value.forEach(items -> {
                    dtos.setId(items.getId());
                    dtos.setName(items.getName());
                    dtos.setAddress(items.getAddress());
                    dtos.setCityName(items.getCity());
                    dtos.setActive(items.getActive());
                    dtos.getShowTimes().add(formatter.format(items.getShowtime()));
                });
                theaterDtos.add(dtos);
            });
            return theaterDtos;
        } catch (Exception ex) {
            throw new DomainException("Error occurred in getTheaterShows: " + ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

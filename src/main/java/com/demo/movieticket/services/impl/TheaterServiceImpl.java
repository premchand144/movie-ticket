package com.demo.movieticket.services.impl;

import com.demo.movieticket.entities.TheaterEntity;
import com.demo.movieticket.entities.TheaterShowEntity;
import com.demo.movieticket.repositories.TheaterShowRepository;
import com.demo.movieticket.rest.dtos.ShowTimingDto;
import com.demo.movieticket.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterShowRepository theaterShowRepository;

    @Transactional
    @Override
    public ShowTimingDto createShows(Integer theaterId, ShowTimingDto showTimingDto) {

        TheaterEntity theater = new TheaterEntity();
        theater.setId(theaterId);

        List<TheaterShowEntity> theaterShowEntities = showTimingDto.getShowTimeIds().stream()
                .map(timingId -> {
                    TheaterShowEntity theaterShowEntity = new TheaterShowEntity();
                    theaterShowEntity.setTheater(theater);
                    theaterShowEntity.setShowDate(showTimingDto.getShowDate());
                    theaterShowEntity.setShowTimingId(timingId);
                    theaterShowEntity.setActive(true);
                    theaterShowEntity.setCreatedAt(LocalDateTime.now());
                    return theaterShowEntity;
                }).collect(Collectors.toList());

        theaterShowRepository.saveAll(theaterShowEntities);
        return showTimingDto;
    }

    @Transactional
    @Override
    public ShowTimingDto updateShows(Integer theaterId, ShowTimingDto showTimingDto) {

        theaterShowRepository.deleteShow(theaterId, showTimingDto.getShowDate());
        this.createShows(theaterId, showTimingDto);
        return showTimingDto;
    }

    @Transactional
    @Override
    public void deleteShows(Integer theaterId, LocalDate showDate) {
        theaterShowRepository.deleteShow(theaterId, showDate);
    }
}

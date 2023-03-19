package com.demo.movieticket.rest.dtos;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ShowTimingDto {

    private Integer id;
    private LocalDate showDate;
    private List<Integer> showTimeIds;

}

package com.demo.movieticket.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TheaterDto extends BaseDto {

    private String name;
    private String address;
    private String cityName;
    private boolean active;
    private Set<String> showTimes;
}

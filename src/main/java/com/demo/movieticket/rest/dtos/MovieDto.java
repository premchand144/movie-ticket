package com.demo.movieticket.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDto extends BaseDto {

    private Set<TheaterDto> theaters;
}

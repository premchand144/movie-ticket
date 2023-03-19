package com.demo.movieticket.query.projections;

import java.time.LocalTime;

public interface TheaterShowDetails {

    Integer getId();
    String getName();
    String getAddress();
    String getCity();
    Boolean getActive();
    LocalTime getShowtime();
}

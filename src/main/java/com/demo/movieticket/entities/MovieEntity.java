package com.demo.movieticket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@Table(name = "MOVIE")
public class MovieEntity extends BaseEntity {

    private String title;
    private String description;
    @Temporal(TemporalType.TIME)
    private LocalTime duration;

    @Column(name = "movie_languages")
    private String language;

    @Temporal(TemporalType.DATE)
    @Column(name = "release_date")
    private LocalDate releaseDate;

    private String dimension;

    @ManyToMany
    @JoinTable(
        name = "MOVIE_THEATER",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "theater_id")
    )
    private Set<TheaterEntity> theaters;
}

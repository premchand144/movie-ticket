package com.demo.movieticket.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "THEATER")
public class TheaterEntity extends BaseEntity {

    private String name;
    private String address;

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private CityEntity city;

    @OneToMany(mappedBy = "theater")
    private Set<TheaterShowEntity> showTimings;
}

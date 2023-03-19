package com.demo.movieticket.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CITY")
public class CityEntity extends BaseEntity {

    private String name;
    private String pincode;

}

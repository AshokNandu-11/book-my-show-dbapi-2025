package com.dbapi.bookmyshow.dbapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name= "show")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID showId;

    @ManyToOne
    Movie movie;

    @ManyToOne
    Hall hall;

    Long startTime;
    Long endTime;

}

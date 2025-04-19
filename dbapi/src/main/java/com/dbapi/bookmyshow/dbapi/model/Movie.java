package com.dbapi.bookmyshow.dbapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID movieId;

    String name;
    Double duration;
    String language;

    boolean isReleased;
    int review;
    int totalReviewVotes;
    @ManyToOne
    AppUser movieOwner;
}

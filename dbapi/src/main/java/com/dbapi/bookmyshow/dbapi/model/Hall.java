package com.dbapi.bookmyshow.dbapi.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "hall")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID hallId;

    @ManyToOne
    Theater theater;

    String hallName;
    int hallCapacity;


}

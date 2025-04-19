package com.dbapi.bookmyshow.dbapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "bookedTickets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookedTickets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID ticketId;

    UUID showId;

    int seatNumber;


}
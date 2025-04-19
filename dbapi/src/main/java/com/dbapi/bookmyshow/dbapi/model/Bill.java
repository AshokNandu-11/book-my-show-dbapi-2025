package com.dbapi.bookmyshow.dbapi.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    UUID billId;

    @ManyToOne
    AppUser user;

    @ManyToOne
    Show show;
    int totalTickets;
    int totalAmount;
    String seats;

    LocalDateTime startShow;
    LocalDateTime endShow;



}
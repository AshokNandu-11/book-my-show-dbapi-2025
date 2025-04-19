package com.dbapi.bookmyshow.dbapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "theater")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID theaterId;

    String name;
    String address;

    int pincode;
    String state;

    String status;

    @ManyToOne
    AppUser owner;


}

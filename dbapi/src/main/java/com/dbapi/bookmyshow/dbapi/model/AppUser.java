package com.dbapi.bookmyshow.dbapi.model;
import com.dbapi.bookmyshow.dbapi.enam.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_api")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID userId;
    String name;

    @Column(unique = true)
    String email;

    String passward;
    String address;

    @Column(unique = true)
    long phoneNumber;

    String state;

    int pincode;

    UserType userType;

}

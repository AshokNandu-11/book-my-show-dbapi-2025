package com.bms.centralapi.central.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    UUID id;
    String name;
    String address;
    int pinCode;
    String state;
    AppUser owner;
    String status;
}

package com.bms.centralapi.central.api.requestBody;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTheaterRB {
    String name;
    String address;
    int pinCode;
    String state;
}

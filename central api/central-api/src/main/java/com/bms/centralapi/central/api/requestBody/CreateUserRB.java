package com.bms.centralapi.central.api.requestBody;

import com.bms.centralapi.central.api.enums.UserType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserRB {
    // Create user request body will contain all the details of user which we ant to save inside the database ?
    // From where we will get what details of user we need to save in the database.
    // By seeing the AppUser model which is created inside the db-api
    String name;
    String email;
    String password;
    Long phoneNumber;
    String address;
    String state;
    int pinCode;
    UserType userType;
}

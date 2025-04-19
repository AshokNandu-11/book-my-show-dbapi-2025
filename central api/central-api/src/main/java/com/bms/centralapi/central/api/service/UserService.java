package com.bms.centralapi.central.api.service;

import com.bms.centralapi.central.api.enums.UserType;
import com.bms.centralapi.central.api.excepions.UserNotFoundException;
import com.bms.centralapi.central.api.integration.DBAPI;
import com.bms.centralapi.central.api.model.AppUser;
import com.bms.centralapi.central.api.requestBody.CreateUserRB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UserService {

    @Autowired
    DBAPI dbapi;

    public Object registerUser(CreateUserRB userRB){
        // Before hitting db api user service will create request for create user endpoint of dbapi
        log.info("Received call from controller to service for request body : " + userRB.toString());
        return dbapi.callCreateUserEndpoint(userRB);
    }

    public AppUser getUserById(UUID userId){
        // we need to call db api to get the user record from the database by userid
        return dbapi.callGetUserByIdEndpoint(userId);
    }

    public boolean isTheaterOwner(UUID theaterOwnerId){
        AppUser theaterOwner = this.getUserById(theaterOwnerId);
        if(theaterOwner == null){
            throw new UserNotFoundException(String.format(
                    "Invalid theater OwnerId %s", theaterOwnerId.toString()
            ));
        }
        return theaterOwner.getUserType().equals(UserType.THEATER_OWNER.toString());
    }

}

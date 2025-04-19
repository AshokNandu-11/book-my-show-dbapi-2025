package com.bms.centralapi.central.api.service;

import com.bms.centralapi.central.api.excepions.UnAuthorizedException;
import com.bms.centralapi.central.api.integration.DBAPI;
import com.bms.centralapi.central.api.model.AppUser;
import com.bms.centralapi.central.api.model.Theater;
import com.bms.centralapi.central.api.requestBody.CreateTheaterRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TheaterService {

    @Autowired
    UserService userService;

    @Autowired
    DBAPI dbapi;

    public Theater raiseCreateTheaterRequest(CreateTheaterRB theaterRB,
                                             UUID theaterOwnerId) throws UnAuthorizedException {
        boolean isTheaterOwner = userService.isTheaterOwner(theaterOwnerId);
        if (!isTheaterOwner){
            throw new UnAuthorizedException(
                    String.format("User with id %s does not have access to create theater.", theaterOwnerId.toString())
            );
        }
        AppUser owner = userService.getUserById(theaterOwnerId);

        // We need to call db api to create theater record inside our theater table.
        return dbapi.callCreateTheaterEndpoint(theaterRB, owner);
    }
}

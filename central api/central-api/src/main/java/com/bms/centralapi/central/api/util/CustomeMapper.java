package com.bms.centralapi.central.api.util;

import com.bms.centralapi.central.api.enums.TheaterStatus;
import com.bms.centralapi.central.api.model.AppUser;
import com.bms.centralapi.central.api.model.Theater;
import com.bms.centralapi.central.api.requestBody.CreateTheaterRB;
import com.bms.centralapi.central.api.requestBody.CreateUserRB;
import org.springframework.stereotype.Service;
@Service
public class CustomeMapper {

    public AppUser mapCreateUserRBToAppUser(CreateUserRB createUserRB){
        AppUser appUser = new AppUser();
        appUser.setName(createUserRB.getName());
        appUser.setEmail(createUserRB.getEmail());
        appUser.setPassword(createUserRB.getPassword());
        appUser.setPincode(createUserRB.getPinCode());
        appUser.setAddress(createUserRB.getAddress());
        appUser.setState(createUserRB.getState());
        appUser.setPhoneNumber(createUserRB.getPhoneNumber());
        appUser.setUserType(createUserRB.getUserType().toString());
        return appUser;
    }

    public Theater mapTheaterRBToTheaterModel(CreateTheaterRB theaterRB, AppUser owner){
        Theater theater = new Theater();
        theater.setAddress(theater.getAddress());
        theater.setOwner(owner);
        theater.setStatus(TheaterStatus.REQUEST_RAISED.toString());
        theater.setPinCode(theater.getPinCode());
        theater.setState(theaterRB.getState());
        theater.setName(theaterRB.getName());
        return theater;
    }

}

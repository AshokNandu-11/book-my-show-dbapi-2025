package com.bms.centralapi.central.api.integration;

import com.bms.centralapi.central.api.model.AppUser;
import com.bms.centralapi.central.api.model.Theater;
import com.bms.centralapi.central.api.requestBody.CreateTheaterRB;
import com.bms.centralapi.central.api.requestBody.CreateUserRB;
import com.bms.centralapi.central.api.util.CustomeMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class DBAPI extends RestApi{

    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    CustomeMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    public AppUser callCreateUserEndpoint(CreateUserRB createUserRB){
        AppUser appUser = mapper.mapCreateUserRBToAppUser(createUserRB);
        String endPoint = "/user/create";
        log.info("Calling /user/create endpoint of dbapi");
        Object resp = this.makePostCall(baseUrl, endPoint, appUser, new HashMap<>());
        AppUser userResp = modelMapper.map(resp, AppUser.class);
        return userResp;
    }

    public AppUser callGetUserByIdEndpoint(UUID userId){
        String endPoint = "/user/" + userId.toString();
        Object resp = this.makeGetCall(baseUrl, endPoint, new HashMap<>());
        if(resp == null){
            return null;
        }
        return modelMapper.map(resp, AppUser.class);
    }

    public Theater callCreateTheaterEndpoint(CreateTheaterRB theaterRB, AppUser owner){
        // we need to map theaterRB to Theater model object
        Theater theater = mapper.mapTheaterRBToTheaterModel(theaterRB, owner);
        String endPoint = "/theater/create";
        Object resp = this.makePostCall(baseUrl, endPoint, theater, new HashMap<>());
        return modelMapper.map(resp, Theater.class);
    }
}

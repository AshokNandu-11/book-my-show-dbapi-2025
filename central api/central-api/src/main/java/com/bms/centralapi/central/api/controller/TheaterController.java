package com.bms.centralapi.central.api.controller;

import com.bms.centralapi.central.api.excepions.UnAuthorizedException;
import com.bms.centralapi.central.api.excepions.UserNotFoundException;
import com.bms.centralapi.central.api.model.Theater;
import com.bms.centralapi.central.api.requestBody.CreateTheaterRB;
import com.bms.centralapi.central.api.responsebody.GeneralMessageResponse;
import com.bms.centralapi.central.api.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RestController
@RequestMapping("/api/v1/central/theater")

public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/register")
    public ResponseEntity registerTheater(@RequestBody CreateTheaterRB theaterRB,
                                          @RequestParam UUID ownerId){
        try{
            Theater theater = theaterService.raiseCreateTheaterRequest(theaterRB, ownerId);
            return new ResponseEntity(theater, HttpStatus.CREATED);
        }catch (UnAuthorizedException e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
        }catch (UserNotFoundException e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

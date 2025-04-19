package com.dbapi.bookmyshow.dbapi.controller;


import com.dbapi.bookmyshow.dbapi.model.AppUser;
import com.dbapi.bookmyshow.dbapi.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/db/user_api")
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;


    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody AppUser user){

        appUserRepository.save(user);

        return  new ResponseEntity(user, HttpStatus.CREATED);

    }
    @GetMapping("/{UserId}")
    public ResponseEntity getUserById(@PathVariable UUID userId){
        AppUser user =  appUserRepository.findById(userId).orElse(null);
        return  new ResponseEntity(user,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody AppUser user){
        appUserRepository.save(user);
        return  new ResponseEntity(user,HttpStatus.OK);
    }
    @DeleteMapping("/{userId}")
    public  ResponseEntity deleteUserById(@PathVariable UUID userId){
        appUserRepository.deleteById(userId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}

package com.dbapi.bookmyshow.dbapi.controller;



import com.dbapi.bookmyshow.dbapi.model.Theater;
import com.dbapi.bookmyshow.dbapi.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/theater")
public class TheaterController {

    @Autowired
    TheaterRepository theaterRepository;

    @PostMapping("/create")
    public ResponseEntity createTheater(@RequestBody Theater theater){
        theaterRepository.save(theater);
        return new ResponseEntity(theater, HttpStatus.CREATED);
    }

    @GetMapping("/{theaterId}")
    public ResponseEntity getTheaterById(@PathVariable UUID theaterId){
        Theater theater = theaterRepository.findById(theaterId).orElse(null);
        return new ResponseEntity(theater, HttpStatus.OK);
    }
    @PutMapping("/updated")
    public ResponseEntity updateTheater(@RequestBody Theater theater){

        theaterRepository.save(theater);
        return new ResponseEntity(theater, HttpStatus.CREATED);
    }
    @DeleteMapping("/{theaterId}")
    public ResponseEntity deleteTheaterById(@PathVariable UUID theaterId){
        theaterRepository.deleteById(theaterId);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}

package com.dbapi.bookmyshow.dbapi.controller;



import com.dbapi.bookmyshow.dbapi.model.Hall;
import com.dbapi.bookmyshow.dbapi.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/hall")
public class HallController {

    @Autowired
    HallRepository hallRepository;

    @PostMapping("/create")
    public ResponseEntity createHall(@RequestBody Hall hall){

        hallRepository.save(hall);
        return new ResponseEntity(hall, HttpStatus.CREATED);
    }
    @GetMapping("/{hallId}")
    public ResponseEntity getHallById(@PathVariable UUID hallId){
        Hall hall = hallRepository.findById(hallId).orElse(null);
        return new ResponseEntity(hall,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateHall(@RequestBody Hall hall){
        hallRepository.save(hall);
        return new ResponseEntity(hall,HttpStatus.CREATED);
    }
    @DeleteMapping("/{hallId}")
    public ResponseEntity deleteHallById(@PathVariable UUID hallId){
        hallRepository.deleteById(hallId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}

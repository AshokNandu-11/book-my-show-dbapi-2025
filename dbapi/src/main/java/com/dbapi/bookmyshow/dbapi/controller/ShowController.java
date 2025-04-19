package com.dbapi.bookmyshow.dbapi.controller;



import com.dbapi.bookmyshow.dbapi.model.Show;
import com.dbapi.bookmyshow.dbapi.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/show")
public class ShowController {

    @Autowired
    ShowRepository showRepository;

    @PostMapping("/create")
    public ResponseEntity createShow(@RequestBody Show show){

        showRepository.save(show);
        return new ResponseEntity(show, HttpStatus.CREATED);
    }
    @GetMapping("/{showId}")
    public ResponseEntity getShowById(@PathVariable UUID showId){
        Show show = showRepository.findById(showId).orElse(null);
        return new ResponseEntity(show, HttpStatus.OK);
    }
    @PutMapping("/updated")
    public ResponseEntity updateShow(@RequestBody Show show){
        showRepository.save(show);
        return new ResponseEntity(show, HttpStatus.CREATED);
    }
    @DeleteMapping("/{showId}")
    public ResponseEntity deleteShowById(@PathVariable UUID showId){
        showRepository.deleteById(showId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}
package com.dbapi.bookmyshow.dbapi.controller;


import com.dbapi.bookmyshow.dbapi.model.BookedTickets;
import com.dbapi.bookmyshow.dbapi.repository.BookedTicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/bookedTickets")
public class BookedTicketsController {

    @Autowired
    BookedTicketsRepository bookedTicketsRepository;

    @PostMapping("/create")
    public ResponseEntity createBookTickets(@RequestBody BookedTickets bookedTickets){

        bookedTicketsRepository.save(bookedTickets);
        return new ResponseEntity(bookedTickets, HttpStatus.CREATED);
    }
    @GetMapping("/{BookedTicketId}")
    public  ResponseEntity getBookedTicketById(@PathVariable UUID bookedTicketId){
        BookedTickets bookedTickets = bookedTicketsRepository.findById(bookedTicketId).orElse(null);
        return new ResponseEntity(bookedTickets,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateBookedTicketsById(@RequestBody BookedTickets bookedTickets){
        bookedTicketsRepository.save(bookedTickets);
        return new ResponseEntity(bookedTickets,HttpStatus.CREATED);
    }
    @DeleteMapping("/{bookedTicketId}")
    public ResponseEntity deleteBookedTicketById(@PathVariable UUID bookedTicketId){
        bookedTicketsRepository.deleteById(bookedTicketId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}

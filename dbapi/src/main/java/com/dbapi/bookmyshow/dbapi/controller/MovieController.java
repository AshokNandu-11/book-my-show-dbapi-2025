package com.dbapi.bookmyshow.dbapi.controller;




import com.dbapi.bookmyshow.dbapi.model.Movie;
import com.dbapi.bookmyshow.dbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/create")
    public ResponseEntity createMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity getMovieById(@PathVariable UUID movieId){

        Movie movie = movieRepository.findById(movieId).orElse(null);
        return new ResponseEntity(movie,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateMovie(@RequestBody Movie movie){
        movieRepository.save(movie);
        return new ResponseEntity(movie,HttpStatus.CREATED);
    }
    @DeleteMapping("/{movieId}")
    public ResponseEntity deleteMovieById(@PathVariable UUID movieId){
        movieRepository.deleteById(movieId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }
}

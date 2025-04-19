package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<Movie, UUID>{
}

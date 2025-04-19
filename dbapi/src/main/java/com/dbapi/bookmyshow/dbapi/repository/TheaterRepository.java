package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheaterRepository extends JpaRepository<Theater, UUID>{
}

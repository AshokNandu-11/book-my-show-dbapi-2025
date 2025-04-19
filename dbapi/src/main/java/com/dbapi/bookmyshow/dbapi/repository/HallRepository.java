package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HallRepository extends JpaRepository<Hall, UUID>{
}

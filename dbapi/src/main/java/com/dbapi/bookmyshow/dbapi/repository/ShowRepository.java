package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowRepository extends JpaRepository<Show, UUID>{
}

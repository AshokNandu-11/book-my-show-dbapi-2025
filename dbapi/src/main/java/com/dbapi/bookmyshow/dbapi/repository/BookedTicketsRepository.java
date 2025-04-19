package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.model.BookedTickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookedTicketsRepository extends JpaRepository<BookedTickets, UUID>{
}

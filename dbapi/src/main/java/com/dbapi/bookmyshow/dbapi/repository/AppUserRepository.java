package com.dbapi.bookmyshow.dbapi.repository;

import com.dbapi.bookmyshow.dbapi.controller.AppUserController;
import com.dbapi.bookmyshow.dbapi.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID>{
}

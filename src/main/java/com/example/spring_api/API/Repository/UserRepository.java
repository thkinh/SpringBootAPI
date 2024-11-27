package com.example.spring_api.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_api.API.Model.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>{

    // Query method to find user by email
    AppUser findByEmail(String email); // Finds a user by their email
}

package com.example.spring_api.API.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_api.API.Model.UnverifiedUser;



@Repository
public interface UnverifiedUserRepository extends JpaRepository<UnverifiedUser, Integer>{

    Optional<UnverifiedUser> findByEmail(String email);
}

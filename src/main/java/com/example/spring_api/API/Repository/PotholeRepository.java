package com.example.spring_api.API.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_api.API.Model.Pothole;

@Repository
public interface PotholeRepository extends JpaRepository<Pothole, Integer> {

    Optional<Pothole> findById(Integer id);
    
}  

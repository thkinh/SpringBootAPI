package com.example.spring_api.API.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_api.API.Model.Pothole;
import com.example.spring_api.API.Repository.PotholeRepository;


@Service
public class PotholeService {

    @Autowired
    private PotholeRepository potholeRepository;
    public PotholeService(){};

    public Optional<Pothole> getPothole(Integer id) {
        return potholeRepository.findById(id);
    }
    
    public Pothole addPothole(Pothole pothole)
    {
        return potholeRepository.save(pothole);
    }

}

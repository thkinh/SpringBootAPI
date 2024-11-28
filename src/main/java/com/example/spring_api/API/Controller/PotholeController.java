package com.example.spring_api.API.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_api.API.Model.Pothole;
import com.example.spring_api.API.Service.PotholeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/pothole")
public class PotholeController {
    
    private final PotholeService potholeService;

    public PotholeController(PotholeService potholeService)
    {
        this.potholeService = potholeService;
    }

    @GetMapping("get")
    public ResponseEntity<Pothole> getPothole(@RequestParam(name = "id") Integer id){
        Optional<Pothole> pothole = potholeService.getPothole(id);

        if (pothole.isPresent()) {
            return ResponseEntity.ok(pothole.get());
        }
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping("path")
    public String addPothole(@RequestBody Pothole pothole) {
        try {
            potholeService.addPothole(pothole);
            return "pothole_added";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
    

}

package com.example.spring_api.API.Controller;

import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.server.ResponseStatusException;

import com.example.spring_api.API.Model.AppUser;
import com.example.spring_api.API.Service.UserService;

import org.springframework.http.ResponseEntity;

//import java.util.Optional;

//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/getuser/mail")
    public ResponseEntity<String> getUsernameByEmail(@RequestParam String email) {
        String username = userService.getUsernameByEmail(email);
        if (username != null) {
            return ResponseEntity.ok(username); // Return the username if found
        } else {
            return ResponseEntity.status(404).body("User not found"); // Return 404 if no user found
        }
    }

    @PostMapping("/api/adduser")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user){
        try {
            AppUser createdUser = userService.addUser(user);
            return ResponseEntity.ok(createdUser); // Return 200 OK with the created user
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Return 500 Internal Server Error on failure
        }
    }


    @GetMapping("/FuckYou")
    public String getFuckYou(@RequestParam(name="name") String param) {
        return String.format("Fuck you %s", param);
    }
    

    


}

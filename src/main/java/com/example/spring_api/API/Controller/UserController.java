package com.example.spring_api.API.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring_api.API.Model.User;
import com.example.spring_api.Service.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> optionalUser = userService.getUser(id);

        // Handle the Optional
        return optionalUser.orElseThrow(() -> 
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
        );
    }


    @GetMapping("/FuckYou")
    public String getFuckYou(@RequestParam(name="name") String param) {
        return String.format("Fuck you %s", param);
    }
    


}

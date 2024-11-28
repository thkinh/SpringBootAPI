package com.example.spring_api.API.Service;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_api.API.Model.AppUser;
import com.example.spring_api.API.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.*;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private String salt = BCrypt.gensalt();
    
    public UserService() {}
    


    public Optional<AppUser> getUserByID(Integer id) {
        // Use findById which returns an Optional
        return userRepository.findById(id);
    }

    public String getUsernameByEmail(String email) {
        AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getUsername(); // Return the username if the user is found
        } else {
            return null; // Return null if the user is not found
        }
    }

    public Integer getIDbyEmail(String email){
        AppUser user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getId();
        }
        return 0;
    }

    public AppUser addUser(AppUser user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), salt));        
        return userRepository.save(user); // Save user to the database
    }
}

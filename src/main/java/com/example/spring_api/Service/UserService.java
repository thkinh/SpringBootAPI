package com.example.spring_api.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.spring_api.API.Model.User;

@Service
public class UserService {

    private List<User> userList;


    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1,"Ida", "gg.com", "ida@mail.com");
        User user2 = new User(2,"Hans", "ff.com", "hans@mail.com");
        User user3 = new User(3,"Lars", "dd.com", "lars@mail.com");
        User user4 = new User(4,"Ben", "ss.com", "ben@mail.com");
        User user5 = new User(5,"Eva", "aa.com", "eva@mail.com");

        userList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    public Optional<User> getUser(Integer id) {
        Optional<User> optional = Optional.empty();
        for (User user: userList) {
            if(id == user.getId()){
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }
}

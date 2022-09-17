package com.springcrudedemo.workoutcrud.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.springcrudedemo.workoutcrud.Models.User;

@Service
public class UserService {
    @GetMapping
    public List<User> getUser(){
        return List.of(
            new User(  
                1,             	
                "sam",
                "fddc@gmail.com",
                "43d"
            )
        );
    }
}

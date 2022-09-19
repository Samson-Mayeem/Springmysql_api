package com.springcrudedemo.workoutcrud.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springcrudedemo.workoutcrud.Models.User;

@Service
public class UserService {
    public List<User> getUser(){
        return List.of(
            new User(  
                1L,             	
                "sam",
                "fddc@gmail.com",
                "43d"
            )
        );
    }
}

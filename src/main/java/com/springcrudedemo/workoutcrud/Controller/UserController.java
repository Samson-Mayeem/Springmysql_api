package com.springcrudedemo.workoutcrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrudedemo.workoutcrud.Models.User;
import com.springcrudedemo.workoutcrud.Services.UserService;



@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    final UserService serService;

    @Autowired
    public UserController(UserService serService) {
        this.serService = serService;
    }

    public List<User> getUser(){
        return serService.getUser();
    }
}

package com.springcrudedemo.workoutcrud.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springcrudedemo.workoutcrud.Models.User;
import com.springcrudedemo.workoutcrud.Services.UserService;

import javax.persistence.Id;


@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUsers();
    }

    @PostMapping
    public void registerUser(@RequestBody User user){
        userService.addUser(user);
    }
    @DeleteMapping(path = "{id}")
    public  void userDelete(@PathVariable("userid") Long Id){
        userService.deleteUser(Id);
    }
}
package com.springcrudedemo.workoutcrud.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springcrudedemo.workoutcrud.Models.User;
import com.springcrudedemo.workoutcrud.Services.UserService;


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
    public  void userDelete(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PutMapping(path = "{id}")
    public void  updateUser(
            @PathVariable ("id") Long id,
            @PathVariable(required = false) String username,
            @PathVariable(required = false) String email,
            @PathVariable(required = false) String password
    ){
        userService.UpdateUser(id, username, email, password);
    }
}
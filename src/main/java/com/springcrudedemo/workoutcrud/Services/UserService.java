package com.springcrudedemo.workoutcrud.Services;

import java.util.List;
import java.util.Optional;

import com.springcrudedemo.workoutcrud.Repository.UserRepository;
import org.springframework.stereotype.Service;

import com.springcrudedemo.workoutcrud.Models.User;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("user already exists");
        }
        userRepository.save(user);
        System.out.println(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("user with Id" + id + "does not exist");
        }
        userRepository.deleteById(id);
    }
}

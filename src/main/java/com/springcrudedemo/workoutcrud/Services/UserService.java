package com.springcrudedemo.workoutcrud.Services;

import com.springcrudedemo.workoutcrud.Models.User;
import com.springcrudedemo.workoutcrud.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void UpdateUser(Long id, String username, String email, String password) {
        User user = userRepository.findById(id).orElseThrow( ()->new IllegalStateException("user with id"+ id + "does not exist"));
        if(username != null && username.length()>0 && !Objects.equals(user.getUsername(), username));
        {
            user.setUsername(username);
        }
        if(email != null && email.length()>0 && !Objects.equals(user.getEmail(), email));
        {
            user.setEmail(email);
        }
        if(password != null && password.length()>0 && !Objects.equals(user.getPassword(), password));
        {
            user.setPassword(password);
        }
    }
}

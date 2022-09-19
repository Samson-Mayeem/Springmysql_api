package com.springcrudedemo.workoutcrud.Repository;

import org.springframework.data.repository.Repository;

import com.springcrudedemo.workoutcrud.Models.User;

public interface UserRepository extends Repository<User, Integer> {

    static Iterable<User> findAll() {
        return null;
    }
    
}

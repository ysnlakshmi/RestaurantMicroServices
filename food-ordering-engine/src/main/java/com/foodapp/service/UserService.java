package com.foodapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.entity.User;
import com.foodapp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    public User findByUsername(String username) {

        System.out.println("Searching for: " + username);

        return userRepository.findByUsername(username)
                .orElse(null);
    }
}
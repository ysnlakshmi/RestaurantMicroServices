package com.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foodapp.dto.LoginRequest;
import com.foodapp.entity.User;
import com.foodapp.security.JwtUtil;
import com.foodapp.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        user.setRole("USER");

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userService.findByUsername(
                request.getUsername());

        if (user != null &&
                user.getPassword().equals(
                        request.getPassword())) {

            return jwtUtil.generateToken(
                    user.getUsername());
        }

        return "Invalid Credentials";
    }
}
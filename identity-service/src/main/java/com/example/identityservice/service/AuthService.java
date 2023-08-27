package com.example.identityservice.service;

import com.example.identityservice.config.AuthConfig;
import com.example.identityservice.entity.UserCredential;
import com.example.identityservice.repository.UserRepository;
import com.example.identityservice.security.JwtTokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    public String saveUser(UserCredential userCredential){
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userRepository.save(userCredential);
        return "User Added to the database";
    }

    public String generateToken(String username){
        return jwtTokenHelper.generateToken(username);
    }

    public void validateToken(String token){
        jwtTokenHelper.validateToken(token);
    }
}

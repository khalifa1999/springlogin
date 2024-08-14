package com.khalifa.authentification.authentification.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Repository.MyAppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegistrationController {

    @Autowired
    private MyAppUserRepository myAppUserRepository;
 
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path= "/req/signup")
    public MyAppUser createUser(@RequestBody MyAppUser myAppUser) {   
        myAppUser.setPassword(passwordEncoder.encode(myAppUser.getPassword()));
        return myAppUserRepository.save(myAppUser);
    }
    
}

package com.khalifa.authentification.authentification.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Repository.MyAppUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MyAppUserService implements UserDetailsService{
    
    @Autowired MyAppUserRepository repository;


    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     Optional<MyAppUser> user = repository.findByEmail(email);
    //     if(user.isPresent()){
    //         var userObj = user.get();
    //         System.out.println("Loaded user: " + userObj.getEmail());
    //         System.out.println("Role: " + userObj.getRole().getRole()); // Logging role
    //                 return User.builder()
    //                 .username(userObj.getEmail())
    //                 .password(userObj.getPassword())
    //                 .build();
    //     }else{
    //         throw new UsernameNotFoundException(email);
    //     }
    // }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<MyAppUser> user = repository.findByEmail(email);
        if (user.isPresent()) {
            MyAppUser userObj = user.get();
            System.out.println("Loaded user: " + userObj.getEmail());
            System.out.println("Role: " + userObj.getRole().getRole()); // Logging role

            // Return the custom UserDetails implementation
            return new MyUsersDetails(userObj);
        } else {
            throw new UsernameNotFoundException(email);
        }
    }




    
}

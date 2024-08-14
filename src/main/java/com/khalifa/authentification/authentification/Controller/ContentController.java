package com.khalifa.authentification.authentification.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Security.JwtTokenUtil;
import com.khalifa.authentification.authentification.Service.MyAppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ContentController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    // @Autowired 
    // private JwtTokenUtil jwtokenutil;


    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody MyAppUser entity) {
    try {
            UsernamePasswordAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(entity.getUsername(), entity.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // If you need to generate a token (like JWT), do it here
            // String token = jwtokenutil.generateToken(authentication);
            
            // Return authentication or token
            return ResponseEntity.ok("Login successful");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    

    public class MyAppUserDTO{
        public String username;
        public String password;   
    }

     
}
 

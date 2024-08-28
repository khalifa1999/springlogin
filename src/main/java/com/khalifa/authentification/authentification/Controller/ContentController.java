package com.khalifa.authentification.authentification.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Security.JwtTokenUtil;
import com.khalifa.authentification.authentification.Service.MyAppUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
public class ContentController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired 
    private JwtTokenUtil jwtokenutil;

    //Test
    @PostMapping("/login")
    public String Login(@RequestBody MyAppUser entity) {
    try {
            UsernamePasswordAuthenticationToken authenticationToken = 
                new UsernamePasswordAuthenticationToken(entity.getEmail(), entity.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // If you need to generate a token (like JWT), do it here
           String token = jwtokenutil.generateToken(authentication);
            
            // Return authentication or token
            //return ResponseEntity.ok("Login successful");
            return token;
        } catch (BadCredentialsException e) {
            return "Erreur sur les credentiels"+ e;
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    

    public class MyAppUserDTO{
        public String username;
        public String password;   
    }

     
}
 

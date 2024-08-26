package com.khalifa.authentification.authentification.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.AppRole;
import com.khalifa.authentification.authentification.Model.MyAppUser;
import com.khalifa.authentification.authentification.Repository.AppRoleRepository;
import com.khalifa.authentification.authentification.Repository.MyAppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class RegistrationController {
 
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private MyAppUserRepository myAppUserRepository;
 
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path= "/req/signup")
    public MyAppUser createUser(@RequestBody MyAppUser myAppUser) {   
        myAppUser.setPassword(passwordEncoder.encode(myAppUser.getPassword()));
        return myAppUserRepository.save(myAppUser);
    }


    @GetMapping(path = "/users")
    public List<MyAppUser> getAppUsers(){
        return myAppUserRepository.findAll();
    }

    @PostMapping("/add/role")
    public AppRole postRole(@RequestBody @Validated AppRole role) {
        return  appRoleRepository.save(role);
    }

    @GetMapping("/roles")
    public List<AppRole> getRoles() {
        return appRoleRepository.findAll();
    }

    @PutMapping("addroletouser/{email}")
    public ResponseEntity<MyAppUser> addRoleToUser(@PathVariable String email) {
        Optional<MyAppUser> appUser = myAppUserRepository.findByEmail(email);

        if (appUser.isPresent()) {
            MyAppUser user = appUser.get();
            user.setRole(appRoleRepository.findById(Long.valueOf(1)).orElse(null));
            myAppUserRepository.save(user);
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
    
    
}

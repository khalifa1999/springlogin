package com.khalifa.authentification.authentification.Service;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.khalifa.authentification.authentification.Model.MyAppUser;


public class MyUsersDetails implements UserDetails{

    private MyAppUser appUser;

    public MyUsersDetails(MyAppUser appUser){
        this.appUser = appUser;
        System.out.println("MyUserDetails constructor called for user: " + appUser.getEmail());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (appUser == null) {
            System.out.println("appUser is null");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        String role = appUser.getRole().getRole();
        System.out.println("Role assigned to user: " + role); // Logging the role
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }


    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getEmail();
    }
    
}

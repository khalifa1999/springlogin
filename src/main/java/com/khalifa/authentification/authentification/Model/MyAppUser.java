package com.khalifa.authentification.authentification.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// On va ajouter une partie pour les rôles admin et users

@Entity
public class MyAppUser {
    

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String username;
    private String email;
    private String password;

    @OneToOne
    private AppRole role;

    public AppRole getRole() {
        return role;
    }
    public void setRole(AppRole role) {
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String toString(){
        return getId()+"-"+getEmail()+"-"+getUsername();
    }


}

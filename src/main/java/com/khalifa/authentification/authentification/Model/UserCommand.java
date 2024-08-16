package com.khalifa.authentification.authentification.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.khalifa.authentification.authentification.Model.Enumeration.Productlist;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class UserCommand {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Productlist productlist;

    private int occurence;

    @OneToOne
    private MyAppUser myAppUser;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public int getOccurence() {
        return occurence;
    }
    public void setOccurence(int occurence) {
        this.occurence = occurence;
    }
    public MyAppUser getMyAppUser() {
        return myAppUser;
    }
    public void setMyAppUser(MyAppUser myAppUser) {
        this.myAppUser = myAppUser;
    }

}

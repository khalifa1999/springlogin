package com.khalifa.authentification.authentification.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;

@Entity
public class UserCommand {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Product> product;

    @OneToOne
    private MyAppUser myAppUser;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public MyAppUser getMyAppUser() {
        return myAppUser;
    }
    public void setMyAppUser(MyAppUser myAppUser) {
        this.myAppUser = myAppUser;
    }

}

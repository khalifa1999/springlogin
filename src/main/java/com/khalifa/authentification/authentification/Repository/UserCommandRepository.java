package com.khalifa.authentification.authentification.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.khalifa.authentification.authentification.Model.UserCommand;

import java.util.List;

@Repository
public interface UserCommandRepository extends JpaRepository<UserCommand, Long>{
    
    List<UserCommand> findByMyAppUserId(Long id);



    // @Query("SELECT u.productlist FROM UserCommand u")
    // List<Productlist> getProductlist();

}

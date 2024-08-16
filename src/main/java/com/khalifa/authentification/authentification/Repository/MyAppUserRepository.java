package com.khalifa.authentification.authentification.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.khalifa.authentification.authentification.Model.MyAppUser;

@Repository
public interface MyAppUserRepository extends JpaRepository<MyAppUser, Long>{


    Optional<MyAppUser> findByUsername(String username);


    Optional<MyAppUser>  findByEmail(String email);

    
}

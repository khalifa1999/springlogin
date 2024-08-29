package com.khalifa.authentification.authentification.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khalifa.authentification.authentification.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
    
}

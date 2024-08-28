package com.khalifa.authentification.authentification.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khalifa.authentification.authentification.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    
}

package com.khalifa.authentification.authentification.Model;

import java.sql.Blob;

import com.khalifa.authentification.authentification.Model.Enumeration.devise;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;


    private String product_name;
    private float product_price;
    private devise devise;
    private Blob product_photo;




    public Blob getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(Blob product_photo) {
        this.product_photo = product_photo;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public devise getDevise() {
        return devise;
    }

    public void setDevise(devise devise) {
        this.devise = devise;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
}

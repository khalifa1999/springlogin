package com.khalifa.authentification.authentification.Model;

import java.sql.Blob;



import com.khalifa.authentification.authentification.Model.Enumeration.devise;

import jakarta.annotation.Nonnull;
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


    @Nonnull
    private String product_name;

    @Nonnull
    private float product_price;

    @Nonnull
    private devise devise;
    private Blob product_photo;
    @Nonnull
    private int stock;



    

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

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

    public void addToStock(int stock){
        this.stock += stock;
    }

    public void removeToStock(int stock){
        this.stock -= stock;
    }

    public void addToStock(){
        this.stock++;
    }

    public void removeOneToStock(){
        this.stock--;
    }
}

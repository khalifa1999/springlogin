package com.khalifa.authentification.authentification.Model.Enumeration;
import java.util.List;

import java.util.Arrays;




public enum Productlist {
    PRODUCT_A("Nike Air Max", 50, "$"),
    PRODUCT_B("Nike Super Fly", 30, "$"),
    PRODUCT_C("Adidas Superstar", 25, "$"),
    PRODUCT_D("Adidas Terex Free Hicker", 16, "$");

    private final String product_name;
    private final int product_price;
    private final String devise;


    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_price() {
        return product_price;
    }


    public String getDevise() {
        return devise;
    }


    Productlist(String product_name, int product_price, String devise){
        this.product_name = product_name;
        this.product_price = product_price;
        this.devise = devise;

    }

        // Method to retrieve enum by product_name
    public static List<Productlist> getAllProducts() {
        return Arrays.asList(Productlist.values());
    }


}

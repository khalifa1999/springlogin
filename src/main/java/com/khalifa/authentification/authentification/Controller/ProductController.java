package com.khalifa.authentification.authentification.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.UserCommand;
import com.khalifa.authentification.authentification.Model.Product;

import com.khalifa.authentification.authentification.Model.Enumeration.devise;
import com.khalifa.authentification.authentification.Repository.ProductRepository;
import com.khalifa.authentification.authentification.Repository.UserCommandRepository;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Arrays;





@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private UserCommandRepository userCommandRepository;


    @Autowired
    private ProductRepository productRepository;
    
    @PostMapping("/product/order")
    public UserCommand userOrder(@RequestBody UserCommand userCommand) {
        UserCommand command = userCommandRepository.save(userCommand);
        return command;
    }

    @PostMapping("/product/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product produit) {
        try{
            Product savedProduct = productRepository.save(produit);
            return ResponseEntity.ok(savedProduct);
        }catch(Exception e){
            //Logging of the errors
            Logger logger = LoggerFactory.getLogger(ProductController.class);
            logger.error("erreur", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }

    @GetMapping("/product/get")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }


    //This method need to be updated
    @PutMapping("/product/update/{id}")
    public ResponseEntity<Product> updateProduit(@PathVariable Long id, @RequestBody Product product) {        
        try{
            if(productRepository.existsById(id)){
                Product updatableProduct = productRepository.findById(Long.valueOf(1)).orElse(null);
                updatableProduct.setId(id);
                updatableProduct.setDevise(product.getDevise());
                updatableProduct.setProduct_name(product.getProduct_name());
                updatableProduct.setProduct_price(product.getProduct_price());
                updatableProduct.setProduct_photo(product.getProduct_photo());
                productRepository.save(updatableProduct);
                return ResponseEntity.ok().body(product);
            }else{
                return ResponseEntity.notFound().build();
            }

           
            
        }catch(Exception e){
            System.out.println("Exception"+ e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<?> deleteMethodName(@PathVariable Long id){
       try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with Id"+id+" not found."); 
            }
       } catch (Exception e) {
            Logger logger = LoggerFactory.getLogger(ProductController.class);
            logger.debug("erreur",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured while deleting the product");
        }
    }



    @GetMapping("/product/devises")
    public List<devise> getDevise() {
        return Arrays.asList(devise.values());
    }
    
    
    

    // @GetMapping("/product/list")
    // public List<Productlist> getProductList() {
    //     return Productlist.getAllProducts();
    // }
    
    

}

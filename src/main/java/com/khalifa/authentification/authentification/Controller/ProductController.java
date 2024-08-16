package com.khalifa.authentification.authentification.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.khalifa.authentification.authentification.Model.UserCommand;
import com.khalifa.authentification.authentification.Model.Enumeration.Productlist;
import com.khalifa.authentification.authentification.Repository.UserCommandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private UserCommandRepository userCommandRepository;
    
    @PostMapping("/order")
    public UserCommand userOrder(@RequestBody UserCommand userCommand) {
        UserCommand command = userCommandRepository.save(userCommand);
        return command;
    }

    @GetMapping("/product/list")
    public List<Productlist> getProductList() {
        return Productlist.getAllProducts();
    }
    
    

}

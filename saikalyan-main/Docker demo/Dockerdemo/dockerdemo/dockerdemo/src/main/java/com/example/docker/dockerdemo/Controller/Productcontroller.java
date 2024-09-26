package com.example.docker.dockerdemo.Controller;
import com.example.docker.dockerdemo.Models.Product;
import com.example.docker.dockerdemo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class Productcontroller {

    @Autowired
    private ProductRepo productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
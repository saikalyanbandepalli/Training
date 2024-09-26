package com.example.docker.dockerdemo.Repository;

import com.example.docker.dockerdemo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{
        }
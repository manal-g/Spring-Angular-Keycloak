package com.manal.inventoryservice.web;

import com.manal.inventoryservice.entities.Product;
import com.manal.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")

public class ProductRestController {


    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();

    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication)
    {
        return authentication;
    }
}

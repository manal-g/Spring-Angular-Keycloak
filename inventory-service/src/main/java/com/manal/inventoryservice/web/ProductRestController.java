package com.manal.inventoryservice.web;

import com.manal.inventoryservice.entities.Product;
import com.manal.inventoryservice.repository.ProductRepository;
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
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();

    }

}

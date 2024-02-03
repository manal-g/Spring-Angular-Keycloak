package com.manal.inventoryservice;

import com.manal.inventoryservice.entities.Product;
import com.manal.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("ComputerASUS")
                            .price(4500)
                            .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Printer")
                    .price(5600)
                    .quantity(12)
                    .build());

        };
    }
}
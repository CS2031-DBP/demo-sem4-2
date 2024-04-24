package com.example.demo.product.application;

import com.example.demo.product.domain.Product;
import com.example.demo.product.domain.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        List<Product> products = service.listAll();

        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Product product) {
        service.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // TODO: Exceptions and DTOs
}

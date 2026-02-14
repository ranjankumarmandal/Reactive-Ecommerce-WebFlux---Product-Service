package com.ranjan.product_service.controller;

import com.ranjan.product_service.entity.Product;
import com.ranjan.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Mono<ResponseEntity<Product>> create(@RequestBody Product product) {
        return service.createProduct(product)
                .map(ResponseEntity::ok);
    }

    @GetMapping
    public Flux<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> getById(@PathVariable Long id) {
        return service.getProductById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}


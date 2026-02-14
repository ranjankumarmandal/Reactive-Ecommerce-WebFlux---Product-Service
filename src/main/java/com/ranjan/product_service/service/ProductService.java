package com.ranjan.product_service.service;

import com.ranjan.product_service.entity.Product;
import com.ranjan.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Mono<Product> createProduct(Product product) {
        return repository.save(product);
    }

    public Flux<Product> getAllProducts() {
        return repository.findAll();
    }

    public Mono<Product> getProductById(Long id) {
        return repository.findById(id);
    }
}


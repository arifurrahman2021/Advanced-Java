package com.github.listdynamictable;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    void saveProduct(Product product) {
        productRepository.save(product);
    }

    List<Product> getAll() {
        return productRepository.findAll();
    }
}

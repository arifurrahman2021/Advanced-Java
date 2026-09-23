package com.github.listdynamictable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInterface extends JpaRepository<Product, Integer> {
}

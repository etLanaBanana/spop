package org.example.shopp.infrastructure.repository;

import org.example.shopp.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByTitle(String title);
}

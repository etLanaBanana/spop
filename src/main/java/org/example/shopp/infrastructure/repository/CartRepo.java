package org.example.shopp.infrastructure.repository;

import org.example.shopp.domain.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}

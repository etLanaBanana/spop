package org.example.shopp.infrastructure.repository;

import org.example.shopp.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {
//    History getCartHistory(Long cartId);
}

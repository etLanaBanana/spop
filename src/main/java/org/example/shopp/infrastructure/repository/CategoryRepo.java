package org.example.shopp.infrastructure.repository;

import org.example.shopp.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByTitleCategory(String titleCategory);
}

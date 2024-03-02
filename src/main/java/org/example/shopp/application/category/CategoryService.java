package org.example.shopp.application.category;

import lombok.RequiredArgsConstructor;
import org.example.shopp.domain.entity.Category;
import org.example.shopp.infrastructure.repository.CategoryRepo;
import org.example.shopp.presentation.category.dto.query.CategoryQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepository;

    public Category getCategoriesByTitle(String title) {
        return categoryRepository.findByTitleCategory(title);
    }
    public Category createCategories(Category categoriesFromCommand) {
        Category categories = categoryRepository.save(categoriesFromCommand);
        return categories;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
}

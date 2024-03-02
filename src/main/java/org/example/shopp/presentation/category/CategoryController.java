package org.example.shopp.presentation.category;

import lombok.AllArgsConstructor;
import org.example.shopp.application.category.CategoryService;
import org.example.shopp.domain.entity.Category;
import org.example.shopp.presentation.category.dto.command.CreateCategoryCommand;
import org.example.shopp.presentation.category.dto.query.CategoryQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @PostMapping("/createCategory")
    public CategoryQuery createNewCategories(@RequestBody CreateCategoryCommand categoriesCommand) {
        Category categoriesFromCommand = new Category();

        categoriesFromCommand.setTitleCategory(categoriesCommand.getTitleCategory());

        Category categories = categoryService.createCategories(categoriesFromCommand);

        CategoryQuery categoriesQueryResponse = modelMapper.map(categories, CategoryQuery.class);
        return categoriesQueryResponse;
    }
    @GetMapping("/getCategories")
    public List<CategoryQuery> getCategories() {
        List<Category> categories = categoryService.getCategories();
        List<CategoryQuery> categoriesQuery = new ArrayList<>();
        for (Category category : categories) {
            categoriesQuery.add(modelMapper.map(category, CategoryQuery.class));
        }
        return categoriesQuery;
    }
}

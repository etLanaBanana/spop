package org.example.shopp.application.product;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.shopp.application.category.CategoryService;
import org.example.shopp.domain.entity.Category;
import org.example.shopp.domain.entity.Product;
import org.example.shopp.infrastructure.repository.ProductRepo;
import org.example.shopp.presentation.product.dto.command.CreateProductCommand;
import org.example.shopp.presentation.product.dto.query.ProductQuery;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public Product addNewProduct(CreateProductCommand createProductCommand) {
        Category categoriesById = categoryService.getCategoryById(createProductCommand.getCategory().getCategoryId());
        if (categoriesById == null) {
            return null;
        }

        Product newProduct = modelMapper.map(createProductCommand, Product.class);
        newProduct.setCategory(categoriesById);

        Product existingProduct = productRepository.findByTitle(newProduct.getTitle());
        if (existingProduct != null) {
            return null;
        }

        productRepository.save(newProduct);
        return newProduct;
    }

    public List<ProductQuery> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductQuery> productsQuery = new ArrayList<>();
        for (Product product : products) {
            productsQuery.add(modelMapper.map(product, ProductQuery.class));
        }
        return productsQuery;
    }
    public Product getProductId(Long id) {
        Product products = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return products;
    }
}

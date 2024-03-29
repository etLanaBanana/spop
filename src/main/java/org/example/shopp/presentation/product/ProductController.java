package org.example.shopp.presentation.product;

import lombok.AllArgsConstructor;
import org.example.shopp.application.product.ProductService;
import org.example.shopp.domain.entity.Product;
import org.example.shopp.infrastructure.routes.ProductRoutes;
import org.example.shopp.presentation.product.dto.command.CreateProductCommand;
import org.example.shopp.presentation.product.dto.query.ProductQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(ProductRoutes.PRODUCTS)
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @PostMapping(ProductRoutes.ADD_NEW_PRODUCT)
    public ProductQuery addNewProduct(@RequestBody CreateProductCommand createProductCommand) {
        Product products = productService.addNewProduct(createProductCommand);
        if (products == null) {
            return null;
        }

        return modelMapper.map(products, ProductQuery.class);
    }
    @GetMapping(ProductRoutes.GET_ALL_PRODUCTS)
    public List<ProductQuery> getProducts() {
        return productService.getProducts();
    }
}

package org.example.shopp.presentation.product.dto.query;

import lombok.Data;


@Data
public class ProductQuery {
    private String title;
    private Long productId;
    private String countryOfOrigin;
    private Long categoryId;
}

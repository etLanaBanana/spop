package org.example.shopp.presentation.product.dto.command;

import lombok.Data;
import org.example.shopp.domain.entity.Category;

import java.time.LocalDateTime;

@Data
public class CreateProductCommand {
    private String titleProduct;
    private Integer price;
    private String countryOfOrigin;
    private Category category;
}

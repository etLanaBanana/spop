package org.example.shopp.presentation.cart.dto.command;

import lombok.Data;

@Data
public class CreateCartCommand {
    private Long userId;
    private Long productId;
}

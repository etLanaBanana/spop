package org.example.shopp.presentation.user.dto.command;

import lombok.Data;

@Data
public class CreateUserCommandToCart {
    private Long productId;
    private Long userId;
}

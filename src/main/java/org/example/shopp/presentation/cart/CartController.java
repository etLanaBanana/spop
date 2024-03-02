package org.example.shopp.presentation.cart;

import lombok.AllArgsConstructor;
import org.example.shopp.application.cart.CartService;
import org.example.shopp.domain.entity.Cart;
import org.example.shopp.presentation.cart.dto.query.CartQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ModelMapper modelMapper;

    @GetMapping("/getCart")
    public Stream<CartQuery> getCart() {
        return cartService.getCart().stream()
                .map(cart -> modelMapper.map(cart, CartQuery.class));
    }

    @DeleteMapping("deleteCartById/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.deleteProductFromCart(id);
    }
}

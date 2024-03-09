package org.example.shopp.presentation.cart;

import lombok.AllArgsConstructor;
import org.example.shopp.application.cart.CartService;
import org.example.shopp.application.user.UserService;
import org.example.shopp.domain.entity.Cart;
import org.example.shopp.infrastructure.routes.CartRoutes;
import org.example.shopp.infrastructure.routes.UserRoutes;
import org.example.shopp.presentation.cart.dto.query.CartQuery;
import org.example.shopp.presentation.user.dto.command.CreateUserCommandToCart;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
@RequestMapping(CartRoutes.CARTS)
public class CartController {
    private final CartService cartService;
    private final ModelMapper modelMapper;

    @GetMapping(CartRoutes.GET_CART)
    public Stream<CartQuery> getCart() {
        return cartService.getCart().stream()
                .map(cart -> modelMapper.map(cart, CartQuery.class));
    }

    @DeleteMapping(CartRoutes.DELETE_CART)
    public void deleteFromCart(@PathVariable Long id) {
        cartService.deleteProductFromCart(id);
    }

    @PostMapping(CartRoutes.ADD_PRODUCT_TO_CART)
    public void addToCart(@RequestBody CreateUserCommandToCart createUserCommand) {
        cartService.addProductToCart(createUserCommand);
    }
}

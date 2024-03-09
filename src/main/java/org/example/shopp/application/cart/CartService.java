package org.example.shopp.application.cart;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.shopp.domain.entity.Cart;
import org.example.shopp.domain.entity.Product;
import org.example.shopp.domain.entity.User;
import org.example.shopp.infrastructure.repository.CartRepo;
import org.example.shopp.infrastructure.repository.ProductRepo;
import org.example.shopp.infrastructure.repository.UserRepo;
import org.example.shopp.presentation.user.dto.command.CreateUserCommandToCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepo cartRepository;
    private final UserRepo userRepository;
    private final ProductRepo productRepository;
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public void deleteProductFromCart(Long id) {
        cartRepository.deleteById(id);
    }
    public void addProductToCart(CreateUserCommandToCart createUserCommand) {
        User user = userRepository.findById(createUserCommand.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Product product = productRepository.findById(createUserCommand.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setProducts(new ArrayList<>());
        }

        cart.getProducts().add(product);
        cartRepository.save(cart);

        product.setCart(cart);
        productRepository.save(product);
    }
}

package org.example.shopp.application.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.shopp.application.product.ProductService;
import org.example.shopp.domain.entity.Cart;
import org.example.shopp.domain.entity.Category;
import org.example.shopp.domain.entity.Product;
import org.example.shopp.domain.entity.User;
import org.example.shopp.infrastructure.repository.CartRepo;
import org.example.shopp.infrastructure.repository.ProductRepo;
import org.example.shopp.infrastructure.repository.UserRepo;
import org.example.shopp.presentation.product.dto.command.CreateProductCommand;
import org.example.shopp.presentation.user.dto.command.CreateUserCommandToCart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepository;
    private final ProductService productService;
    private final CartRepo cartRepository;
    private final ProductRepo productRepository;


    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public void addProductToCart(CreateUserCommandToCart createUserCommand) {
        User user = userRepository.findById(createUserCommand.getUserId()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Product> product = (List<Product>) productRepository.findById(createUserCommand.getProductId()).orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cartRepository.save(cart);
    }

}

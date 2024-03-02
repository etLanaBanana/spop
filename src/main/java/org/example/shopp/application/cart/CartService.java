package org.example.shopp.application.cart;

import lombok.RequiredArgsConstructor;
import org.example.shopp.domain.entity.Cart;
import org.example.shopp.infrastructure.repository.CartRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepo cartRepository;
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public void deleteProductFromCart(Long id) {
        cartRepository.deleteById(id);
    }
}

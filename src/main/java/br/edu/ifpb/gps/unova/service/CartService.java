package br.edu.ifpb.gps.unova.service;

import br.edu.ifpb.gps.unova.model.CartItem;
import br.edu.ifpb.gps.unova.repository.CartItemRepository;
import jakarta.transaction.Transactional;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem addToCart(CartItem cartItem) {
        if (cartItem.getId() != null) { // Se o ID não for nulo, verificamos se o item já existe no banco
            Optional<CartItem> existingItem = cartItemRepository.findById(cartItem.getId());
            if (existingItem.isPresent()) {
                CartItem managedItem = existingItem.get();
                managedItem.setQuantity(managedItem.getQuantity() + cartItem.getQuantity());
                return cartItemRepository.save(managedItem); // Salvar o item já gerenciado
            }
        }
    
        cartItem.setVersion(0); // Se for um novo item, garantir que a versão seja inicializada corretamente
        return cartItemRepository.save(cartItem);
        
    }

    public void removeFromCart(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Transactional
    public void updateCartItem(Long id, Integer quantity) {
        cartItemRepository.updateQuantity(id, quantity);
    }

    public void clearCart() {
        cartItemRepository.deleteAll();
    }
}

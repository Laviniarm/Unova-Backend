package br.edu.ifpb.gps.unova.controller;

import br.edu.ifpb.gps.unova.model.CartItem;
import br.edu.ifpb.gps.unova.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping
    public ResponseEntity<List<CartItem>> getCartItems() {
        return ResponseEntity.ok(cartService.getCartItems());
    }

    @PostMapping
    public ResponseEntity<CartItem> addToCart(@RequestBody CartItem cartItem) {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBB"+cartItem);
        System.out.println("Recebendo produto no carrinho: " + cartItem);
        System.out.println("ID: " + cartItem.getId());
        System.out.println("Nome: " + cartItem.getName());
        System.out.println("Quantidade: " + cartItem.getQuantity());
        System.out.println("Versão: " + cartItem.getVersion());
        return ResponseEntity.ok(cartService.addToCart(cartItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/clear")
    public ResponseEntity<Void> clearCart() {
        cartService.clearCart();
        return ResponseEntity.noContent().build();
    }


}

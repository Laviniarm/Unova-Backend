package br.edu.ifpb.gps.unova.repository;

import br.edu.ifpb.gps.unova.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAll();
}

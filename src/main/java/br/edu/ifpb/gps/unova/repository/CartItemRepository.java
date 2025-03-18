package br.edu.ifpb.gps.unova.repository;

import br.edu.ifpb.gps.unova.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findAll();
    
@Modifying
@Query("UPDATE CartItem c SET c.quantity = :quantity WHERE c.id = :id")
void updateQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);
}

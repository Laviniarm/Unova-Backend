package br.edu.ifpb.gps.unova.repository;

import br.edu.ifpb.gps.unova.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

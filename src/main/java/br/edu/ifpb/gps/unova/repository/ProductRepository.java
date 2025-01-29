package br.edu.ifpb.gps.unova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.gps.unova.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

package br.edu.ifpb.gps.unova.service;

import br.edu.ifpb.gps.unova.model.Product;
import br.edu.ifpb.gps.unova.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}

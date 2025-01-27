package br.edu.ifpb.gps.unova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.gps.unova.model.Product;
import br.edu.ifpb.gps.unova.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setQuantity(product.getQuantity());

            return Optional.of(productRepository.save(productToUpdate));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> productToDelete = productRepository.findById(id);

        if (productToDelete.isPresent()) {
            productRepository.delete(productToDelete.get());
            return true;
        } else {
            return false;
        }
    }

}

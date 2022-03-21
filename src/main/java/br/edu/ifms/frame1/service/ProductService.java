package br.edu.ifms.frame1.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.frame1.model.Product;
import br.edu.ifms.frame1.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }


    public Product getProductById(UUID id) {
        return this.productRepository.getById(id);
    }


    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }


    public void deleteProductById(UUID id) {
        this.productRepository.deleteById(id);
    }
}

package br.edu.ifms.frame1.service;

import java.util.List;

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


    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }
}

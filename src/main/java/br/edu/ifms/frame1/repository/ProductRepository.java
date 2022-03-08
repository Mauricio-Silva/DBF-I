package br.edu.ifms.frame1.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.frame1.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}

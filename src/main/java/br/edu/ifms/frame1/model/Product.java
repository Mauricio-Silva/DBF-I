package br.edu.ifms.frame1.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "ProductName", nullable = false)
    @NotBlank
    String name;
    @Column(name = "ProductQuantity")
    Integer quantity;
    @Column(name = "ProductPrice")
    Double price;
    @Column(name = "ProductDescription")
    String description;
}

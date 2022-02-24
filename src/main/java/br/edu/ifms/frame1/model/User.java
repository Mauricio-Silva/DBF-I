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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "userName", nullable = false)
    @NotBlank
    String nome;
    String email;
}

//Data - Getters e Setters
//AllArgsConstructor - Construtor Completo Automático
//NoArgsConstructor - Retira Construtor de Default
//Entity - Transforma a Classe em Tabela
//Id - Define o Atributo da Classe como sendo o Atributo Idemtificador(ID) da Tabela
//GeneratedValue - Gera Valores para o Atributo
//Column - Define Especifições da Coluna
//NotBlank - Não Nulo
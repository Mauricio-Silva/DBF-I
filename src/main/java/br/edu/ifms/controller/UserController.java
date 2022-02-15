package br.edu.ifms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/listar")
    public String getUser() {
        return "User is Here!";
    }
}

//RestController - Classe Controladora
//RequestMapping - Especifica o Caminho
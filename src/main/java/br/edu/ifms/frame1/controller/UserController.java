package br.edu.ifms.frame1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.frame1.model.User;
import br.edu.ifms.frame1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getUser() {
        return "User is Here!";
    }

    @GetMapping("/")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("listAll");
        List<User> users = this.userService.getUsers();
        mv.addObject("usersList", users);

        return mv;
    }
}

//RestController - Classe Controladora
//RequestMapping - Especifica o Caminho
//ModelAndView - Chama HTML passando parametros para exibir como resposta em vez de uma simples string
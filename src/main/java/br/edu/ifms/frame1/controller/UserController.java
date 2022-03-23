package br.edu.ifms.frame1.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.frame1.model.User;
import br.edu.ifms.frame1.model.UserNotFoundException;
import br.edu.ifms.frame1.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public ModelAndView getUser() {        
        return new ModelAndView("userIndex");
    }



    @GetMapping("/listAll")
    public ModelAndView listAll() {
        ModelAndView html = new ModelAndView("listAllUsers");
        List<User> usersList = this.userService.getUsers();
        html.addObject("usersList", usersList);

        return html;
    }



    @GetMapping("/register")
    public ModelAndView registerUser() {
        ModelAndView html = new ModelAndView("userRegister");
        html.addObject("noUserData", new User());

        return html;
    }



    @PostMapping("/save")
    public ModelAndView saveUser(@Valid User userFromRegister, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:pageError");
        }
        
        this.userService.saveUser(userFromRegister);
        ModelAndView html = new ModelAndView("redirect:/users/listAll");
        html.addObject("save", "User saved Successfully");

        return html;
    }   



    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") UUID id) throws UserNotFoundException {
        try {
            this.userService.getUserById(id);
        }   
        catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException("User Not Found");
        }     
         
        this.userService.deleteUserById(id);
        ModelAndView html = new ModelAndView("redirect:/users/listAll");
        html.addObject("delete", "User deleted Successfully");

        return html;
    }


    
    @GetMapping("/select/{id}")
    public ModelAndView selectUser(@PathVariable("id") UUID id) throws UserNotFoundException {
        try {
            User userForUpdate = this.userService.getUserById(id);
            ModelAndView html = new ModelAndView("userUpdate");
            html.addObject("userForUpdate", userForUpdate);
            return html;
                
        } 
        catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException("User Not Found");
        }        
    }



    @PostMapping("/update")
    public ModelAndView updateUser(@Valid User userFromRegister, BindingResult result, RedirectAttributes redirect) throws UserNotFoundException {
        try {
            this.userService.getUserById(userFromRegister.getId());
        }   
        catch (UserNotFoundException e) {
            e.printStackTrace();
            throw new UserNotFoundException("User Not Found");
        }   

        if (result.hasErrors()) {
            return new ModelAndView("redirect:pageError");
        }

        User DBuser = this.userService.getUserById(userFromRegister.getId());
        DBuser.setName(userFromRegister.getName());
        DBuser.setEmail(userFromRegister.getEmail());
        this.userService.saveUser(DBuser);

        ModelAndView html = new ModelAndView("redirect:/users/listAll");
        html.addObject("update", "User updated Successfully");

        return html;
    }
}

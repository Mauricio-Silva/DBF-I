package br.edu.ifms.frame1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
        ModelAndView mv = new ModelAndView("listAllUsers");
        List<User> users = this.userService.getUsers();
        mv.addObject("usersList", users);

        return mv;
    }



    /*
    @PostMapping("/{id}")
    public RedirectView getById(@RequestBody User user) {
        User user = this.userService.getById(id);
        if (user.isPresent()) {
            return new RedirectView (user.get(), HttpStatus.OK);
        } 
        else {
            throw new RecordNotFoundException();
        }
    }

    @PostMapping(value = "book", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Book> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
		bookService.addBook(book);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/book/{id}").buildAndExpand(book.getBookId()).toUri());
		return new ResponseEntity<Book>(book, headers, HttpStatus.CREATED);
	}	
	
	@PostMapping(value = "send", consumes = { MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public String userData(@RequestBody byte[] data) {
		bookService.userData(data);
		return "Data sent.";
	}
    */
}

//RestController - Classe Controladora
//RequestMapping - Especifica o Caminho
//ModelAndView - Chama HTML passando parametros para exibir como resposta em vez de uma simples string
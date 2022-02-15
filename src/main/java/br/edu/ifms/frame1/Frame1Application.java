package br.edu.ifms.frame1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Frame1Application {

	public static void main(String[] args) {
		SpringApplication.run(Frame1Application.class, args);
	}

	//GET, POST, DELETE, PUT, PATCH
	
	@GetMapping("/")
	public String hello(){
		return "My Page String";
	}

	
}

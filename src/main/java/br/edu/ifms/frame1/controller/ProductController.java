package br.edu.ifms.frame1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifms.frame1.model.Product;
import br.edu.ifms.frame1.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/list")
    public String getProduct() {
        return "Product is Here!";
    }


    @GetMapping("/")
    public ModelAndView listAll() {
        ModelAndView mv = new ModelAndView("listAllProducts");
        List<Product> products = this.productService.getProducts();
        mv.addObject("productsList", products);

        return mv;
    }


    @GetMapping("/register")
    public ModelAndView registerProduct() {
        ModelAndView mv = new ModelAndView("productRegister");
        mv.addObject("product", new Product());
        return mv;
    }


    @PostMapping("/save")
    public ModelAndView saveProduct(@Valid Product product, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:pageError");
        }
     
        this.productService.saveProduct(product);
        redirect.addAttribute("mensage", "Product registered Successfully");
        
        return new ModelAndView("redirect:/products/");
    }
}

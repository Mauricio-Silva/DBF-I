package br.edu.ifms.frame1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
}

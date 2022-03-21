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

import br.edu.ifms.frame1.model.Product;
import br.edu.ifms.frame1.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public ModelAndView getProduct() {
        return new ModelAndView("productIndex");
    }



    @GetMapping("/listAll")
    public ModelAndView listAll() {
        ModelAndView html = new ModelAndView("listAllProducts");
        List<Product> productsList = this.productService.getProducts();
        html.addObject("productsList", productsList);

        return html;
    }



    @GetMapping("/register")
    public ModelAndView registerProduct() {
        ModelAndView html = new ModelAndView("productRegister");
        html.addObject("noProductData", new Product());

        return html;
    }



    @PostMapping("/save")
    public ModelAndView saveProduct(@Valid Product productFromRegister, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:pageError");
        }
     
        this.productService.saveProduct(productFromRegister);
        ModelAndView html  = new ModelAndView("redirect:/products/listAll");
        html.addObject("save", "Product saved Successfully");

        return html;
    }



    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") UUID id) {
        this.productService.deleteProductById(id);
        ModelAndView html = new ModelAndView("redirect:/products/listAll");
        html.addObject("delete", "Product deleted Successfully");

        return html;
    }



    @GetMapping("/select/{id}")
    public ModelAndView selectProduct(@PathVariable("id") UUID id) {
        Product productForUpdate = this.productService.getProductById(id);
        ModelAndView html = new ModelAndView("productUpdate");
        html.addObject("productForUpdate", productForUpdate);

        return html;
    }



    @PostMapping("/update")
    public ModelAndView updateProduct(@Valid Product productFromRegister, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors() || productFromRegister.getId() == null) {
            return new ModelAndView("redirect:pageError");
        }

        Product DBproduct = this.productService.getProductById(productFromRegister.getId());
        DBproduct.setName(productFromRegister.getName());
        DBproduct.setQuantity(productFromRegister.getQuantity());
        DBproduct.setPrice(productFromRegister.getPrice());
        DBproduct.setDescription(productFromRegister.getDescription());
        this.productService.saveProduct(DBproduct);

        ModelAndView html = new ModelAndView("redirect:/products/listAll");
        html.addObject("update", "Product update Successfully");

        return html;
    }
}

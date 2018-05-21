package guru.springframework.controllers;

import guru.springframework.domains.Product;
import guru.springframework.services.ProductService;
import guru.springframework.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProduct() {

        return "redirect:/";
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable Integer id, Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "product";
    }
}

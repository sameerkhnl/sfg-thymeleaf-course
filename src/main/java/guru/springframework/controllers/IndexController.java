package guru.springframework.controllers;

import guru.springframework.domains.Product;
import guru.springframework.services.ProductService;
import guru.springframework.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    private ProductService productService;

    @Autowired
    public IndexController(ProductService productService){
        this.productService = productService;
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(Model model) {
        model.addAttribute("products", productService.listProducts());
        return "index";
    }
}

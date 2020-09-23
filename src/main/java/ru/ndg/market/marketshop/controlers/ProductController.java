package ru.ndg.market.marketshop.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ndg.market.marketshop.model.Product;
import ru.ndg.market.marketshop.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getListProduct(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "all_product";
    }

    @GetMapping("/edit/{id}")
    public String getEditProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("/edit")
    public String saveProduct(@ModelAttribute Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String getAddProductsForm() {
        return "add_product";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}

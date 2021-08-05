package ru.geekbrains.webapp.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.webapp.springwebapp.model.Product;
import ru.geekbrains.webapp.springwebapp.services.ProductService;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/show/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.fundById(id));
        return "product_info";
    }


    @PostMapping("/minusCost/")
    public String minusProductCost(@RequestParam Long productId) {
        productService.minusCost(productId);
        return "redirect:/show_all";
    }

    @PostMapping("/plusCost/")
    public String plusProductCost(@RequestParam Long productId) {
        productService.plusCost(productId);
        return "redirect:/show_all";
    }


    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProducts(@RequestParam Long id, @RequestParam String name, @RequestParam int cost) {
        Product product = new Product(id, name, cost);
        productService.save(product);

        return "redirect:/show_all";
    }
}

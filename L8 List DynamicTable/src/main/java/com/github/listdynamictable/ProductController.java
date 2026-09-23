package com.github.listdynamictable;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    private final List<Product> products = new ArrayList<>();

    @GetMapping("add")
    public String ShowProductForm(Model model) {
        model.addAttribute("product", new Product());

        return "form";
    }

    @PostMapping("add")
    public String addProduct(@Valid @ModelAttribute Product product,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        products.add(product);
        log.info("Added product {}" + product);
        return "redirect:/product/add";
    }

    @GetMapping("list")
    public String listProducts(Model model) {
        model.addAttribute("productList", products);
        return "list";
    }
}

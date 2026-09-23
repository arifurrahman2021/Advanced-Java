package com.github.validation;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {
    @GetMapping("add")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("add")
    public String addProduct(@Valid @ModelAttribute Product products,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        log.info("Adding product {}", products);
        return "redirect:/product/add";
    }
}

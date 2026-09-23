package com.java.l7;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@Controller
//@RequestMapping("/product")
public class ProductController {
    private final List<Product> products = new ArrayList<>();
    @GetMapping("add")
    public String product(Model model){
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("add")
    public String requestProduct(@Valid @ModelAttribute Product product,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "product";
        }
        System.out.print(product);
        products.add(product);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id,
                       Model model) {
        Product product = getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable long id,
                         @ModelAttribute Product updateProduct,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product";
        }

        Product product = getProductById(id);
        if (product == null) {
            return "redirect:/list";
        }

        product.setProductName(updateProduct.getProductName());
        product.setProductDescription(updateProduct.getProductDescription());

        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        products.remove(getProductById(id));
        return "redirect:/list";
    }

    public Product getProductById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}

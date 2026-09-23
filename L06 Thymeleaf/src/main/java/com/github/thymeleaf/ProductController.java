package com.github.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ProductController {
    @GetMapping("product")
    public String productPage() {
        return "product";
    }

    @PostMapping("ordered-product")
    public String orderedProduct(@ModelAttribute OrderProduct orderProduct) {
        log.info("ordered product {} ", orderProduct);
        return "redirect:/product";
    }
    @PostMapping("request-product")
    public String requestProduct(@ModelAttribute RequestProduct requestProduct) {
        log.info("Product Product: {}", requestProduct);
        return "redirect:/product";
    }
}

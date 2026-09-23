package com.github.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("contact-us")
    public String contactUsPage() {
        return "contact";
    }

    @PostMapping("contact-us")
    public String submitForm(@RequestParam String name,
                             @RequestParam(name = "emailAddress", required = false) String email,
                             @RequestParam String message) {
        System.out.println("Submitting form " + name + " " + email + " " + message);
        return "contact";
    }
}

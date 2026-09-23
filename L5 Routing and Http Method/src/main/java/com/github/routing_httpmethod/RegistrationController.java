package com.github.routing_httpmethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("register")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("register")
    public String submitRegistrationForm(
            @RequestParam int id,
            @RequestParam(name = "emailAddress") String email,
            //required false means here is 3 parameter but if we pass 2 it takes 2 parameter, if required true it gives an error because 3 parameter we pass only 2
            //@RequestParam(name = "emailAddress", required = false) String email,
            @RequestParam String password) {
        System.out.print("Submitting registration form " + "ID: " + id + " " + "Email: " + email + " " + "Password: " + password);
        return "registration";
    }
}

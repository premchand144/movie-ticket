package com.demo.movieticket.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class WelcomeController {

    @GetMapping("/welcome")
    public String sayHello() {
        return "Welcome to movie ticket booking system!";
    }
}

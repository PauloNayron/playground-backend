package com.example.playgroundbackend.controller;

import com.example.playgroundbackend.config.security.UserLoggedIn;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String getHello () {
        System.out.println(UserLoggedIn.getUser());
        return "Hello World";
    }

    @GetMapping("/seguro")
    @PreAuthorize("hasAuthority('HELLO_USER')")
    public String getHelloSeguro() {
        return "Hello World com segurança";
    }
}

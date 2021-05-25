package com.example.playgroundbackend.controller;

import com.example.playgroundbackend.config.security.UserLoggedIn;
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
}

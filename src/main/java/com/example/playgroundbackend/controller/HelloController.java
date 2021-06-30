package com.example.playgroundbackend.controller;

import com.example.playgroundbackend.config.security.UserLoggedIn;
import com.example.playgroundbackend.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    private HelloWorldService helloWorldService;

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

    @PostMapping("/send")
    public void postSqs(@RequestBody String teste) {
        log.info("HelloController.postSqs -> body: ".concat(teste));
        helloWorldService.producer(teste);
    }
}

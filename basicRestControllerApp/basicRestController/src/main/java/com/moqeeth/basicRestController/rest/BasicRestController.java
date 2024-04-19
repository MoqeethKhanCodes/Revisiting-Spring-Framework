package com.moqeeth.basicRestController.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {
    // expose "/ endpoint that return "Hello World"

    @GetMapping("/")
    public String sayHello() {
        return "Hello, My name is Moqeeth!";
    }
}

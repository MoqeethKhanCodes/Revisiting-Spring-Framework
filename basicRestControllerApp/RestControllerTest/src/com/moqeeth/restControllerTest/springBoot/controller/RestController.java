package com.moqeeth.restControllerTest.springBoot.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/rest")

    public String restTest() {
        return "REST API TEST";
    }
}

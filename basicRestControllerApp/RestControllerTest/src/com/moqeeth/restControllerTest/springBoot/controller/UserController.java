package com.moqeeth.restControllerTest.springBoot.controller;

import com.moqeeth.restControllerTest.springBoot.model.User;
import com.moqeeth.restControllerTest.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //ConciseFormat of getUserDetails1
    @GetMapping("/userInfo")
    public User getUserDetails(@RequestParam Integer id) {

        Optional<User> user = userService.getUser(id);

        return user.orElse(null);

    }

    @GetMapping("/userInfo1")
    public User getUserDetails1(@RequestParam Integer id) {

        Optional user = userService.getUser(id);

        if (user.isPresent()) {
            return (User) user.get();
        }

        return null;
    }
}

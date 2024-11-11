package org.moqeeth.controller;

import org.moqeeth.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/home")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("/getProfile")
    public void getProfile() throws IOException {
        profileService.getProfile();
    }

    @PostMapping("/sendProfile")
    public String postProfile() throws IOException {
        return profileService.sendProfile();
    }

}

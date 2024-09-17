package com.moqeeth.dependencyInjection.controller;

import com.moqeeth.dependencyInjection.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private Coach myCoach;

    @Autowired
    public HomeController(Coach myCoach) {
        this.myCoach = myCoach;
    }

    @GetMapping("/getDailyWorkouts")
    public String getTraining (){
        return myCoach.getDailyWorkout();
    }
}

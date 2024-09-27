package com.moqeeth.dependencyInjection.controller;

import com.moqeeth.dependencyInjection.service.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public HomeController(@Qualifier("footBallCoach") Coach myCoach, @Qualifier("footBallCoach") Coach theOtherCoach) {
        System.out.println("in Constructor : " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = theOtherCoach;
    }

    @GetMapping("/getDailyWorkouts")
    public String getTraining (){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkBeans () {
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}

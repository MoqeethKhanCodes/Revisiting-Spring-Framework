package com.moqeeth.dependencyInjection.service;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{
    public BasketBallCoach() {
        System.out.println("in Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "BASKETBALL | Netting and Dribble Practice";
    }
}

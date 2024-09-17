package com.moqeeth.dependencyInjection.service;

import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Improve Stamina using various workout sessions";
    }
}

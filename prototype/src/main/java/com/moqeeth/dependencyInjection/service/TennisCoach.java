package com.moqeeth.dependencyInjection.service;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach() {
        System.out.println("in Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "TENNIS | Improve Stamina using various workout sessions";
    }
}

package com.moqeeth.dependencyInjection.service;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("in Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "CRICKET | Bowling and Batting Practice";
    }
}

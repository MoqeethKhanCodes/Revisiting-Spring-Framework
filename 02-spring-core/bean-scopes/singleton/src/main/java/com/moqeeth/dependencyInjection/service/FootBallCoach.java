package com.moqeeth.dependencyInjection.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class FootBallCoach implements Coach{
    public FootBallCoach() {
        System.out.println("in Constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "FOOTBALL | Ball Control, dribble and Improve Stamina using various workout sessions";
    }
}

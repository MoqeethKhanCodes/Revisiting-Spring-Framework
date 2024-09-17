package com.moqeeth.dependencyInjection.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class OAuthSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/").permitAll() // Allow access to the home page without authentication
                                .anyRequest().authenticated() // Any other request requires authentication
                ) .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
    }

}

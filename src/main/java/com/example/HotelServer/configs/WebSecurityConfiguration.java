package com.example.HotelServer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        try {
            httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request->
                    request.requestMatchers("/api/auth/**").permitAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return httpSecurity.build();
    }
}

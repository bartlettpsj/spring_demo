package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//import java.util.logging.Level;
//import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("DOING AUTH");

        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/employees", "/employees/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
    // other necessary beans and definitions
}
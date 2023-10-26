package com.FormUser.Person.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .csrfTokenRepository(new HttpSessionCsrfTokenRepository());

        return http.build();
    }
}

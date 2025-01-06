package com.goodbuy.googbuylogin.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@Autowired(required = false) HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // 禁用 CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 允许所有请求
                );
        return http.build();
    }
}

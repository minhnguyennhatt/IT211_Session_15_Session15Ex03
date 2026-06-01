package com.session15ex03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> auth
                        // Trang chủ cho phép truy cập công khai
                        .requestMatchers("/").permitAll()

                        // Mọi endpoint còn lại đều phải đăng nhập
                        .anyRequest().authenticated()
                )

                // Bật form login mặc định của Spring Security
                .formLogin(form -> form.permitAll())

                // Cho phép logout
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}

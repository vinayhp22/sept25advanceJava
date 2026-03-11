package com.skyllx.sppring_security_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
         return http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth->auth
                        .requestMatchers("/login", "/login.html", "/perform_login")
                                .permitAll()
                        .requestMatchers("/admin", "/admin.html").hasRole("ADMIN")
                        .requestMatchers("/home", "/home.html").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form->form
                        .loginPage("/login.html")
                        .loginProcessingUrl("/perform_login")
                        .failureUrl("/login.html?error=true")
                        .successHandler((request, response, authentication) -> {
                            boolean isAdmin = authentication.getAuthorities().stream()
                                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
                            if (isAdmin) {
                                response.sendRedirect("/admin");
                            } else {
                                response.sendRedirect("/home");
                            }
                        }))
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

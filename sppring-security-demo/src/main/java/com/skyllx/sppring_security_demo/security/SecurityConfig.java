package com.skyllx.sppring_security_demo.security;

import com.skyllx.sppring_security_demo.filter.JWTFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {
         return http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth->auth
                        .requestMatchers("/login")
                                .permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .formLogin(form->form.disable()
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                                .exceptionHandling(e->e.
                                        authenticationEntryPoint(
                                                (request,
                                                 response,
                                                 authException) ->
                                                        response.sendRedirect("/login")))
//                        .loginPage("/login.html")
//                        .loginProcessingUrl("/perform_login")
//                        .failureUrl("/login.html?error=true")
//                        .successHandler((request, response, authentication) -> {
//                            boolean isAdmin = authentication.getAuthorities().stream()
//                                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
//                            if (isAdmin) {
//                                response.sendRedirect("/admin");
//                            } else {
//                                response.sendRedirect("/home");
//                            }
//                        })
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config){
        return config.getAuthenticationManager();
    }
}

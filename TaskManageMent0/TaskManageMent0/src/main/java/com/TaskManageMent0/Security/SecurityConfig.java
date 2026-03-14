package com.TaskManageMent0.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    // Password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Authentication manager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .cors(Customizer.withDefaults())         // enable CORS
                .csrf(csrf -> csrf.disable())            // disable CSRF for REST APIs
                .authorizeHttpRequests(auth -> auth
                        // 1️⃣ Allow all OPTIONS requests first (preflight)
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // 2️⃣ Allow public endpoints
                        .requestMatchers(
                                "/",
                                "/login",
                                "/error",
                                "/favicon.ico",
                                "/api/auth/**",
                                "/api/workflows/**",
                                "/api/boards/**"                   // login/signup APIs
                        ).permitAll()

                        // 3️⃣ Protect all other endpoints
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    // Ignore static resources (JSP or other)
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/WEB-INF/**");
    }

    // CORS configuration for React + Angular frontends
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allowed origins (your frontend dev servers)
        String number = "5177";
        configuration.setAllowedOrigins(List.of(
                "http://localhost:" + number, // React dev URL
                "http://localhost:4200"  // Angular dev URL
        ));

        // Allowed HTTP methods
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allowed headers
        configuration.setAllowedHeaders(List.of("*"));

        // Allow credentials (cookies/sessions)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        System.out.println(" CORS configured for frontend origins.");
        return source;
    }
}

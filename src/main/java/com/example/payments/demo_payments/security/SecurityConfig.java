package com.example.payments.demo_payments.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    UserDetailsService userDetailsService;
    PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    //AUTHENTICATION
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    //AUTHORIZATION

    @Bean
    public SecurityFilterChain openUrls(HttpSecurity http)
            throws Exception {

        http.securityMatcher("/health", "/swagger-ui/**","/v3/api-docs/**")
                .authorizeHttpRequests( auth ->
                        auth.anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public SecurityFilterChain adminAccessForPosts(HttpSecurity http)
            throws Exception {

        http.authorizeHttpRequests( auth ->
                        auth.requestMatchers(HttpMethod.POST, "/**")
                                .hasRole("ADMIN"))
                        .csrf(csrf -> csrf.disable())
                        .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public SecurityFilterChain userAndAdminAccess(HttpSecurity http)
            throws Exception {

        http.securityMatcher("/**")
                .authorizeHttpRequests( auth ->
                        auth.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}

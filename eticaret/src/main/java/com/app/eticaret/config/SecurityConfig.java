package com.app.eticaret.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/app/customer").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/app/customer/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/app/customer").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/app/customer/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/app/customer/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/app/product").permitAll()
                        .requestMatchers(HttpMethod.POST, "/app/product").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/app/product/**").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}

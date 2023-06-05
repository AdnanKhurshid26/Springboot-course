package com.adnan.todowebapp.security;

import static org.springframework.security.config.Customizer.*;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        Function<String,String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails1 = createUser("adnan", passwordEncoder.apply("adnan"), "USER","ADMIN");
        UserDetails userDetails2 = createUser("dummy", passwordEncoder.apply("dummy"), "USER");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);

    }

    private UserDetails createUser(String username,String password,String... roles) {
        return User.builder()
        .username(username)
        .password(password)
        .roles(roles)
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
            );
            
            http.formLogin(withDefaults());
            http.csrf().disable();
            http.headers().frameOptions().disable();
            return http.build();


    }


}

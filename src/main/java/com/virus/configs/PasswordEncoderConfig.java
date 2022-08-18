package com.virus.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

    /*
     * Password encoder configuration class. It is required to use Spring Security.
     * 
     * It is annotated as a @Bean
     */
    @Bean
    PasswordEncoder passwordEnconder() {
        return new BCryptPasswordEncoder();
    }
}

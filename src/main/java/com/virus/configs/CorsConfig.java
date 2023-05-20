package com.virus.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig {
	
	
	@Bean
	WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                	.allowedOrigins("*")
                	.allowedMethods("GET", "POST", "PUT", "DELETE")
                	.exposedHeaders("Authorization", "Content-Type", "Content-Disposition"); // Needed for add headers to response
            }
        };
    }
}

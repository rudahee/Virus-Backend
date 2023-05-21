package com.virus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class VirusApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirusApplication.class, args);
		
	}

	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                	.allowedOrigins("*")
                	.allowedMethods("GET", "POST", "PUT", "DELETE")
                	.exposedHeaders("Authorization", "Content-Type", "Content-Disposition");
            }
        };
    }
}

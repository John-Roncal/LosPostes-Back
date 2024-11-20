package com.backend.LosPostes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.backend.LosPostes.config.jwt.JwtProperties;

@SpringBootApplication
@EnableConfigurationProperties(JwtProperties.class)
public class LosPostesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LosPostesApplication.class, args);
	}
}

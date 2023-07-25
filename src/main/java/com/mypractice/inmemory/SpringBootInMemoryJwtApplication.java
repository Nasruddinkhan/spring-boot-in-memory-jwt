package com.mypractice.inmemory;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SecurityScheme(
		name = "in-memory",
		type = SecuritySchemeType.APIKEY,
		bearerFormat = "JWT",
		scheme = "Bearer",
		paramName = "Authorization",
		in = SecuritySchemeIn.HEADER
)
@SpringBootApplication
public class SpringBootInMemoryJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInMemoryJwtApplication.class, args);
	}

}

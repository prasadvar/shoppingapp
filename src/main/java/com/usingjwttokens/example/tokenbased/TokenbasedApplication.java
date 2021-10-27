package com.usingjwttokens.example.tokenbased;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TokenbasedApplication extends SpringBootServletInitializer {
//extends SpringBootServletInitializer
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(TokenbasedApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(TokenbasedApplication.class, args);
	}


}

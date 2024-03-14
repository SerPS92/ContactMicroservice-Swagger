package com.example.ContactMicroserviceSwagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class ContactMicroserviceSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactMicroserviceSwaggerApplication.class, args);
		System.out.println(SpringVersion.getVersion());
		System.out.println("Since Spring Boot 3.0, Swagger is not supported.");
	}

}

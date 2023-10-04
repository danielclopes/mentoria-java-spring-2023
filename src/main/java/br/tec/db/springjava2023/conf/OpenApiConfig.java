package br.tec.db.springjava2023.conf;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title = "Mentoria API",
		version = "0.1.0",
		contact = @Contact(name= "Mentoria", email = "mentoria@mail.com"),
		description = "API para mentoria de Spring Boot e Java"))
public class OpenApiConfig {
}
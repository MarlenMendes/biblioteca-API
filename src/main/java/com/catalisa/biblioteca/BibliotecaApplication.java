package com.catalisa.biblioteca;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Biblioteca API", version = "1", description = "Api para gerenciamento de biblioteca"))
public class BibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

}

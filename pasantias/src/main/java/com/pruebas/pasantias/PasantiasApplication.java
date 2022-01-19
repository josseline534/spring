package com.pruebas.pasantias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@EnableSwagger2
@SpringBootApplication
public class PasantiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasantiasApplication.class, args);
	}

}

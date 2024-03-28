package com.misael.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title= "service order api",version = "1", description = "Api para cadastros de pessoas e criação de ordem de serviço."))
@Tag(name = "service-order-api")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

package com.formaci.nbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Producto API", version = "2.0", description = "Microservicio Productos"))
@EntityScan("com.formaci.nbdi.springboot.app.commons.models.entity")
public class CursoServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServicioProductosApplication.class, args);
	}

}

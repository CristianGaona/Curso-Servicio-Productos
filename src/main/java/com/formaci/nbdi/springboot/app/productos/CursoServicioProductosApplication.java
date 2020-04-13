package com.formaci.nbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan("com.formaci.nbdi.springboot.app.commons.models.entity")
public class CursoServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServicioProductosApplication.class, args);
	}

}

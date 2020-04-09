package com.formaci.nbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CursoServicioProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServicioProductosApplication.class, args);
	}

}

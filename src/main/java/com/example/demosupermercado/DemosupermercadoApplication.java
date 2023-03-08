package com.example.demosupermercado;

import com.example.demosupermercado.model.entities.Articulo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DemosupermercadoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemosupermercadoApplication.class, args);
	}

}

package com.br.api.cliente.config;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SwaggerDefinition(basePath = "http://localhost:8080/api/swagger-ui.html", 
info = @Info(description = "Serviço para CRUD de clientes conductor", title = "Cliente REST API", version = "1.0", 
contact = @io.swagger.annotations.Contact(email = "josemalyson@gmail.com", name = "Josemalyson Oliveira", url = "http://localhost:8080/api/")))
public class ConfigurationCliente implements Serializable {

	private static final long serialVersionUID = -2035291587503040138L;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}

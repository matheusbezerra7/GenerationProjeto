package org.generation.redesocial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis( RequestHandlerSelectors.basePackage("org.generation.redesocial.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Rede Social")
				.description("API do Projeto Integrador")
				.version("1.0")
				.contact(contact())
				.build();
				
	}
	
	private Contact contact() {
		return new Contact("Matheus Bezerra, Matheus Bello, Gabriela Pereira, Yuri Santiago, Elaine Paiva",
				 "https://github.com/matheusbezerra7 , https://github.com/Mathbello , https://github.com/gabrielaprg , https://github.com/YuriSantiago999 , https://github.com/ElaineCSP",
	             "Desenvolvedores Generation !");
					
				
	}
}

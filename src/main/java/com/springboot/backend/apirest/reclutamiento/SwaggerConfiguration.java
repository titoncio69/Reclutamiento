package com.springboot.backend.apirest.reclutamiento;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	public static final Contact DEFAULT_CONTACT = new Contact(
            "Cristian Marambio",
            "https://www.tecnomp.cl",
            "cristianmarambio17@gmail.com");
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Mediapp Api Documentation",
            "Mediapp Api Documentation",
            "1.0",
            "PREMIUM",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<VendorExtension>());
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.select()
	        		.apis(RequestHandlerSelectors.basePackage("com.springboot.backend.apirest.reclutamiento.controller"))
	        		.paths(PathSelectors.any())
	        		.build()
	        		.apiInfo(DEFAULT_API_INFO);
	    }
}

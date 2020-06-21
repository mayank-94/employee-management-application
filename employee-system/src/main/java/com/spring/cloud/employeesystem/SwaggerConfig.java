package com.spring.cloud.employeesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Mayank", "", "mayankjain123450@gmail.com");
	
	@SuppressWarnings("rawtypes")
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("REST Api Documentation", 
			  "Employee Management System", 
			  "1.0", 
			  "Terms Of Service",
	          DEFAULT_CONTACT, "Apache 2.0", 
	          "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	 private static final Set<String> DEFAULT_PRODUES_AND_CONSUMES = 
			new HashSet<String>(Arrays.asList("application/json"));
	 
	 @Bean
	 public Docket api() {
		 return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUES_AND_CONSUMES)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.cloud"))
				.paths(PathSelectors.any())
				.build();
	 }
	
}

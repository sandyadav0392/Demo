package com.example.demo.swager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//http://localhost:9195/v2/api-docs	
	//http://localhost:9195/swagger-ui.html
// its provide api info 
@Bean
public Docket api() { 
	 
    return new Docket(DocumentationType.SWAGGER_2)  
      .select()                                  
      .apis(RequestHandlerSelectors.basePackage("com.example.demo.resource"))              
      .paths(PathSelectors.any()) 
      .build()
      .apiInfo(apiInfo())
      ;                                           
}

 public ApiInfo apiInfo() {
	 ApiInfo info=new ApiInfo("Spring Boot Rest Api",
			 "This is for Testing",
			  "1.0", 
			  "sandeep.com",
			    "sandeep",
			  "Apache.org",
			     "www.sandy.com");
	 
	 
	 return info;
 }
}
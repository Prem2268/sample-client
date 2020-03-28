package com.sample.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public Docket apiInfo() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sample.client.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(getApinInfo());
	}
	
	private ApiInfo getApinInfo() {
		return new ApiInfoBuilder().title("Two way SSL authentication gateway")
	            .description("Two way SSL authentication gateway")
	            .version("1.0.0")
	            .license(null)
	            .licenseUrl(null)
	            .build();

	}

}

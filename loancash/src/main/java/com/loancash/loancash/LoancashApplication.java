package com.loancash.loancash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LoancashApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(LoancashApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LoancashApplication.class);
	}

	@Bean
	public RestTemplate restTemplate() {
				
		return new RestTemplate();
	}
}

package com.cg.TMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TMSApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TMSApplication.class, args);
		System.out.println("welcome");

	}


}

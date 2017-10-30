package com.efrei.wstp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.efrei.service",
		"com.efrei.web",
		"com.efrei.domain" }) 
public class Wstp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Wstp1Application.class, args);
	}
}

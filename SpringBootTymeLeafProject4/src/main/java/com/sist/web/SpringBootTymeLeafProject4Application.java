package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = "com.sist.web.*")
@SpringBootApplication
public class SpringBootTymeLeafProject4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTymeLeafProject4Application.class, args);
	}

}

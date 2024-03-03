package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.sist.controller")
public class SpringBootThymeLeaf1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThymeLeaf1Application.class, args);
	}

}

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class Day1Application {

	public static void main(String[] args) {
		SpringApplication.run(Day1Application.class, args);
	}

}

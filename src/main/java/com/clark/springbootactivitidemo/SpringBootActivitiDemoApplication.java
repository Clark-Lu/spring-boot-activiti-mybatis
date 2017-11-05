package com.clark.springbootactivitidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.clark.springbootactivitidemo"})
public class SpringBootActivitiDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivitiDemoApplication.class, args);
	}
}

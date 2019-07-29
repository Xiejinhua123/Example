package com.xiejinhua.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackages={"com.xiejinhua"})
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
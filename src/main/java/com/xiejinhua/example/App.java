package com.xiejinhua.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.xiejinhua.example.dao")
@ServletComponentScan("com.xiejinhua.example")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

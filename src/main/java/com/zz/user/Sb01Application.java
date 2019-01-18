package com.zz.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zz.user")
public class Sb01Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb01Application.class, args);
	}
}

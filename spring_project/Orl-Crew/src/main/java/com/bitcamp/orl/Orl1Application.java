package com.bitcamp.orl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bitcamp.orl.crew.mapper")
public class Orl1Application {

	public static void main(String[] args) {
		SpringApplication.run(Orl1Application.class, args);
	}

}

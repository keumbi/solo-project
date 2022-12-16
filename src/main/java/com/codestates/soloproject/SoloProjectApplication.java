package com.codestates.soloproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoloProjectApplication extends SpringBootServletInitializer { // 1. SpringBootServletInitializer 상속

	public static void main(String[] args) {
		SpringApplication.run(SoloProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { // 2. config를 override 이때 return되는 값의 클래스 이름에 유의, 애플리케이션 설정에 따라 ~Application의 이름은 상이할 수 있다.
		return builder.sources(SoloProjectApplication.class);
	}

}

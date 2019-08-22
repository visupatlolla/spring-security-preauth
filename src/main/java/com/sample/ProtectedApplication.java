package com.sample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProtectedApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		new ProtectedApplication().configure(new SpringApplicationBuilder(ProtectedApplication.class)).run(args);
	}

}

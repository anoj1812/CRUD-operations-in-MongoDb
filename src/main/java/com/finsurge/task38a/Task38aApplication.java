package com.finsurge.task38a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Task38aApplication {

	public static void main(String[] args) {
		SpringApplication.run(Task38aApplication.class, args);
	}

}

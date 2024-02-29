package com.zhl.lt.lexical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LexicalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LexicalServiceApplication.class, args);
	}

}

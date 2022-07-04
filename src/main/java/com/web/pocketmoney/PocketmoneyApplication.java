package com.web.pocketmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PocketmoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketmoneyApplication.class, args);
	}

}

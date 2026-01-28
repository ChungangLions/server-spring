package com.example.ChungangLions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ChungangLionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChungangLionsApplication.class, args);
	}

}

package com.eco.cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.eco.cycle.repository")
public class EcocycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcocycleApplication.class, args);
	}
}
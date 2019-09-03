package com.product.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan

@EnableJpaRepositories("org.baeldung.persistence.repo")
@EntityScan("org.baeldung.persistence.model")
@SpringBootApplication
public class Application {

	static void main(String[] args) {
		SpringApplication.run(Application.class, args)
	}

}

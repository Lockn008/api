package com.product.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@EntityScan
@SpringBootApplication
class Application {

	static void main(String[] args) {
		SpringApplication.run(Application.class, args)
	}

}

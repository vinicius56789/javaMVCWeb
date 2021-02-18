package com.everis.mvc.bmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching // ativar cache
@SpringBootApplication
public class BmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmtApplication.class, args);
	}

}

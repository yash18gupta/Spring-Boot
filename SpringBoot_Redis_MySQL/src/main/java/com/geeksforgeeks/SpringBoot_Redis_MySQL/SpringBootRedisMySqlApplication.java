package com.geeksforgeeks.SpringBoot_Redis_MySQL;

import jakarta.persistence.Cacheable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisMySqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisMySqlApplication.class, args);
	}

}

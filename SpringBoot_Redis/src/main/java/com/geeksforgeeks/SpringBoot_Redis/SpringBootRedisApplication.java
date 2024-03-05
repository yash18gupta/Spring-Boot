package com.geeksforgeeks.SpringBoot_Redis;

import com.geeksforgeeks.SpringBoot_Redis.entity.Product;
import com.geeksforgeeks.SpringBoot_Redis.repo.ProductDAORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

	@Autowired
	public ProductDAORepo dao;

	@GetMapping("/test")
	public String test(){
		return "Test API Works!";
	}

	@GetMapping("/")
	public List<Object> fetchProducts(){
		return dao.getAll();
	}

	@PostMapping("/")
	public Product save(@RequestBody Product product){
		return dao.save(product);
	}

}

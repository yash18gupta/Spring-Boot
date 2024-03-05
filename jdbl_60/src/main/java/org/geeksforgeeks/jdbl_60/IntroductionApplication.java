package org.geeksforgeeks.jdbl_60;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class IntroductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionApplication.class, args);
	}

	@RequestMapping("/")
	public String test(){
		System.out.println("Test API works");
		return "Test API works";
	}
	@RequestMapping("/greet")
	public String greet(@RequestParam String name){
		String msg = "";
		if(name==null || name.equals("")){
			msg = "Hello unknown!";
		}
		else{
			msg = "Hello"+name;
		}
		return msg;
	}
	@RequestMapping("/greet/{name}")
	public String greet1(@PathVariable String name){
		return "Hello from : " + name;
	}
}

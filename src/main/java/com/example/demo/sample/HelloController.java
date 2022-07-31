package com.example.demo.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String helloWorld() {
		System.out.println("GetMapping of helloWorld is running-HelloController");
		return "welcome to my first app" ;
	}
}

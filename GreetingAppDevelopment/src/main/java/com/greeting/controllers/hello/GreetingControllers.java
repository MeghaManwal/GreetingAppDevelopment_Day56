package com.greeting.controllers.hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeting.controllers.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingControllers {
	

	@Autowired 
	GreetingService greetingService;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	//UC-1(command:curl -X GET "http://localhost:8080/greeting" -w "\n")
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	//UC-2 (command:curl -X GET "http://localhost:8080/greeting/get/all)
	@GetMapping("/get/all")
	public List<Greeting> getGreeting(){
		return greetingService.getAll();
	}
}

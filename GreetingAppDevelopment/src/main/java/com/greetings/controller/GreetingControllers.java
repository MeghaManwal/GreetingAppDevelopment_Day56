package com.greetings.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greetings.model.Greeting;
import com.greetings.model.User;
import com.greetings.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingControllers {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private IGreetingService greetingService;
	
	//UC-2
	@GetMapping(value={"","/", "/home"})
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
		
	}
	
	//UC-3
	@PostMapping("/post")
	public String sayHello(@RequestBody User user) {
		return "Hello " + user.getFirstName() + " " + user.getLastName() + " !!";
	}

	@PutMapping("/put/{firstName}")
	public String sayHello(@PathVariable String firstName,
			               @RequestParam(value="lastName") String lastName) {
		return "Hello " + firstName +" "+ lastName + " !!";
	}
	
	//UC-5 To find Greeting Message by Id
	@GetMapping("/message/{id}")
	public Greeting getByid(@PathVariable long id) {
		return greetingService.getGreetingById(id);	
	}
	
	//UC-6 To find All the Greeting Message
	@GetMapping("/getAll")
	public List<Greeting> getAllContent() {
		return greetingService.getAllGreetings();
	}
	
	//UC-8 To Delete Greeting Message By Id
	@GetMapping("/delete/{id}")
	public String deleteByid(@PathVariable long id) {
		return greetingService.deleteGreetingById(id);	
	}
	
}

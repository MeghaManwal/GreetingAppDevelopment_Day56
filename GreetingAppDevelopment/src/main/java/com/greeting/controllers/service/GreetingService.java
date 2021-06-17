package com.greeting.controllers.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.greeting.controllers.hello.Greeting;
import com.greeting.controllers.repository.GreetingRepository;

public class GreetingService {
	
	@Autowired 
	GreetingRepository greetingRepository;
	
	public List<Greeting> getAll() {
		return greetingRepository.getAll();
	}

	public String add(Greeting greet) {
		return greetingRepository.add(greet);
	}

}

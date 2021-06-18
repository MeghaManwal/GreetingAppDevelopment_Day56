package com.greetings.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greetings.model.Greeting;
import com.greetings.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService{
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	public GreetingRepository greetingRepository;
	
	//UC-4 To save Greeting Messages in the Repository
	@Override
	public Greeting addGreeting(com.greetings.model.User user) {
		String message =String.format(template,  (user.toString().isEmpty()) ? "Hello World" :user.toString());		
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
	}
	
    //UC-5 To find Greeting Message by Id
	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}
	
	
	

}

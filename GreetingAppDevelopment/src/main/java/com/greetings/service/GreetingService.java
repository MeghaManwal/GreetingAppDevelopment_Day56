package com.greetings.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
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
	
    
	@Override
	public Greeting getGreetingById(long id) {
		return greetingRepository.findById(id).get();
	}

	
	@Override
	public List<Greeting> getAllGreetings() {
		List<Greeting> greetings = new ArrayList<Greeting>();
		greetingRepository.findAll().forEach(greetings::add); 
		return greetings;
	}

	
	@Override
	public String deleteGreetingById(long id) {
		greetingRepository.deleteById(id);
		return "Deleted"+ " "+"Content with id: "+id;
	}	

}

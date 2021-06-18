package com.greetings.service;

import java.util.List;

import com.greetings.model.Greeting;
import com.greetings.model.User;

public interface IGreetingService {
	
	public Greeting addGreeting(User user);
	public Greeting getGreetingById(long id);
	public List<Greeting> getAllGreetings();

}

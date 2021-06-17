package com.greeting.controllers.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.greeting.controllers.hello.Greeting;

@Repository
public class GreetingRepository {
	
	public List<Greeting> greeting = new ArrayList<Greeting>();

	public List<Greeting> getAll() {
		return greeting;
	}

	public String add(Greeting greet) {
		greeting.add(greet);
		return "Sucessfully Saved !";
	}

}

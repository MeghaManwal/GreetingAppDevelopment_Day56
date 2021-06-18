package com.greetings.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
	
	@Id
	private final long id;
	private final String content;

	public Greeting() {
		id = 0;
		content = " ";
	}
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}

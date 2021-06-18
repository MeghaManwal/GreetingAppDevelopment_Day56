package com.greetings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greetings.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}

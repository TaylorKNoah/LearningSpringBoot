package com.codewithmosh.springboot_exercises;

import com.codewithmosh.springboot_exercises.exercises.userregistration.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootExercisesApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(SpringbootExercisesApplication.class, args);
		var userService = context.getBean(UserService.class);
		userService.registerUser("test1@gmail.com", "dude", "password");
	}

}

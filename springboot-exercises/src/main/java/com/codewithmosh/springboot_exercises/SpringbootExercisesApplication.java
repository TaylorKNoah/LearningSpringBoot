package com.codewithmosh.springboot_exercises;

import com.codewithmosh.springboot_exercises.exercises.entities.data.Profile;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.ProfileRepository;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.codewithmosh.springboot_exercises.exercises.entities.services.UserService;
@SpringBootApplication
public class SpringbootExercisesApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(SpringbootExercisesApplication.class, args);
		/*var userService = context.getBean(UserService.class);
		userService.showRelatedEntities();*/

		/*var profileRepository = context.getBean(ProfileRepository.class);
		var profile = Profile.builder()
				.bio("here ye here ye")
				.id(2L)
				.loyaltyPoints(5)
				.phoneNumber("1231231234")
				.build();
		profileRepository.save(profile);*/

		var userRepository = context.getBean(UserRepository.class);
	}

}

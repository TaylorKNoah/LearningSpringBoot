package com.codewithmosh.springboot_exercises.exercises.entities.repositories;

import com.codewithmosh.springboot_exercises.exercises.entities.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

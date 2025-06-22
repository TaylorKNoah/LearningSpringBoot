package com.codewithmosh.springboot_exercises.exercises.entities.repositories;

import com.codewithmosh.springboot_exercises.exercises.entities.data.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);
}

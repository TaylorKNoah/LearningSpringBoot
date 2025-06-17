package com.codewithmosh.springboot_exercises.exercises.entities.repositories;

import com.codewithmosh.springboot_exercises.exercises.entities.data.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

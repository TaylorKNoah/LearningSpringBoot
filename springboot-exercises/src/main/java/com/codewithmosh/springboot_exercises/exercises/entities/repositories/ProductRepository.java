package com.codewithmosh.springboot_exercises.exercises.entities.repositories;

import com.codewithmosh.springboot_exercises.exercises.entities.data.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}

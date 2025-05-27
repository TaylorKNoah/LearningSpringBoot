package com.codewithmosh.springboot_exercises.exercises.userregistration.userrepository;

import com.codewithmosh.springboot_exercises.exercises.userregistration.data.RegistrationResult;
import com.codewithmosh.springboot_exercises.exercises.userregistration.data.User;

public interface IUserRepository {
    void save(User user);
    User findByEmail(String email);
}

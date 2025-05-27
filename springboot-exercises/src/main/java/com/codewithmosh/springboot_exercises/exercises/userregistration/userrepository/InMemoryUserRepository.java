package com.codewithmosh.springboot_exercises.exercises.userregistration.userrepository;

import com.codewithmosh.springboot_exercises.exercises.userregistration.data.RegistrationResult;
import com.codewithmosh.springboot_exercises.exercises.userregistration.data.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements IUserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        user.id = (long) users.size();
        this.users.put(user.email, user);
    }

    @Override
    public User findByEmail(String email){
        return users.getOrDefault(email, null);
    }
}

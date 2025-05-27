package com.codewithmosh.springboot_exercises.exercises.userregistration.data;

import org.springframework.lang.Nullable;

public class User {
    @Nullable
    public Long id;
    public String email;
    public String name;
    public String password;

    public User(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}

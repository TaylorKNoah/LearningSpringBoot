package com.codewithmosh.springboot_exercises.exercises.entities.services;

import com.codewithmosh.springboot_exercises.exercises.entities.data.User;
import com.codewithmosh.springboot_exercises.exercises.entities.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional
    public void showEntityStates(){
        var user = User.builder()
                .name("taylor")
                .email("taylor@gmail.com")
                .password("yoda123")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    public void showRelatedEntities(){
        var user = userRepository.findById(2L).orElseThrow();
        System.out.println(user.getEmail());
    }
}

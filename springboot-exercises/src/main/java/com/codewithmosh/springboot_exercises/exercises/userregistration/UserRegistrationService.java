package com.codewithmosh.springboot_exercises.exercises.userregistration;

import com.codewithmosh.springboot_exercises.exercises.userregistration.data.User;
import com.codewithmosh.springboot_exercises.exercises.userregistration.notifications.INotificationService;
import com.codewithmosh.springboot_exercises.exercises.userregistration.userrepository.IUserRepository;

public class UserRegistrationService {
    private IUserRepository userRepository;
    private INotificationService notificationService;

    public UserRegistrationService(IUserRepository userRepository, INotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(String email, String name, String password){
        var incomingUser = new User(null, email, name, password);

        if (userRepository.findByEmail(email) != null){
            throw new IllegalArgumentException("User with email '"+email+"' already exists!");
        }

        this.userRepository.save(incomingUser);
        var newUser = userRepository.findByEmail(email);

        notificationService.send("Hello, "+newUser.name+", your account has been created!", newUser.email);
    }
}

package com.codewithmosh.springboot_exercises.exercises.userregistration;

import com.codewithmosh.springboot_exercises.exercises.userregistration.notifications.EmailNotificationService;
import com.codewithmosh.springboot_exercises.exercises.userregistration.notifications.INotificationService;
import com.codewithmosh.springboot_exercises.exercises.userregistration.userrepository.IUserRepository;
import com.codewithmosh.springboot_exercises.exercises.userregistration.userrepository.InMemoryUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRegistrationConfig {
    @Value("${user-registration.notification-service:Email}")
    private String notificationService;

    @Value("${user-registration.user-repository:InMemory}")
    private String userRepository;

    @Bean
    public INotificationService email(){
        return new EmailNotificationService();
    }

    @Bean
    public IUserRepository inMemory() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService() throws Exception {
        INotificationService notificationService;
        switch (this.notificationService){
            case "Email":
                notificationService = email();
                break;
            default:
                throw new Exception("User Service Config: Unrecognized notification service: "+this.notificationService);
        }
        IUserRepository userRepository;
        switch (this.userRepository){
            case "InMemory":
                userRepository = inMemory();
                break;
            default:
                throw new Exception("User Service Config: Unrecognized user repository: "+this.userRepository);
        }

        return new UserService(userRepository, notificationService);
    }
}

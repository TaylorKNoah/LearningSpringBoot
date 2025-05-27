package com.codewithmosh.springboot_exercises.exercises.userregistration.notifications;

import org.springframework.beans.factory.annotation.Value;

public class EmailNotificationService implements INotificationService {
    @Value("${user-registration.notification-service.host}")
    private String host;

    @Value("${user-registration.notification-service.port}")
    private int port;

    @Override
    public void send(String message, String recipientEmail) {
        System.out.println("Email Notification Service");
        System.out.println("Host: "+this.host);
        System.out.println("Port: "+this.port);
        System.out.println("Message: "+message);
        System.out.println("Recipient Email: "+recipientEmail);
    }
}

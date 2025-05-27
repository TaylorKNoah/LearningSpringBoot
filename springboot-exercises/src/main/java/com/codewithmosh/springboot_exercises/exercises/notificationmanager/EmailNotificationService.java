package com.codewithmosh.springboot_exercises.exercises.notificationmanager;

public class EmailNotificationService implements INotificationService {
    @Override
    public void send(String message) {
        System.out.println("EMAIL");
        System.out.println("Message: " + message);
    }
}

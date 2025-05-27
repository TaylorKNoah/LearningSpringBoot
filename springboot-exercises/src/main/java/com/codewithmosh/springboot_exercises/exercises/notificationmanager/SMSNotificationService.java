package com.codewithmosh.springboot_exercises.exercises.notificationmanager;

public class SMSNotificationService implements INotificationService{
    @Override
    public void send(String message) {
        System.out.println("SMS");
        System.out.println("Message: " + message);
    }
}

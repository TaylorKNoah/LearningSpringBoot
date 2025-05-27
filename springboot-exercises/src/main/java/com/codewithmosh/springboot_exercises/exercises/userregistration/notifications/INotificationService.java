package com.codewithmosh.springboot_exercises.exercises.userregistration.notifications;

public interface INotificationService {
    void send(String message, String recipientEmail);
}

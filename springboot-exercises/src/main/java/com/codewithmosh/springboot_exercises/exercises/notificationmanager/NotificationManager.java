package com.codewithmosh.springboot_exercises.exercises.notificationmanager;

public class NotificationManager {
    private final INotificationService notificationService;

    public NotificationManager(INotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void send(String message){
        notificationService.send(message);
    }
}

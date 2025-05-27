package com.codewithmosh.springboot_exercises.exercises.notificationmanager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Value("${notification-manager.service:Email}")
    private String notificationService;

   // @Bean
    public INotificationService email(){
        return new EmailNotificationService();
    }

   // @Bean
    public INotificationService sms(){
        return new SMSNotificationService();
    }

   // @Bean
    public NotificationManager notificationManager() throws Exception {
        INotificationService notificationService;
        switch(this.notificationService){
            case "Email":
                notificationService = email();
                break;
            case "SMS":
                notificationService = sms();
                break;
            default:
                throw new Exception("Notification Config: Unrecognized notification service: '"+ this.notificationService+"'");
        }
        return new NotificationManager(notificationService);
    }
}

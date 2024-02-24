package org.sesame.ms.notification.services;

import org.sesame.ms.notification.beans.ProjectJoinNotification;
import org.sesame.ms.notification.configuration.NotificationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

@Service
public class NotificationService {

    @Autowired
    private NotificationHandler notificationHandler;

    // Method to trigger sending a notification
    public void triggerNotification(ProjectJoinNotification notificationResponse, WebSocketSession session) {
        try {
            notificationHandler.sendNotification(session, notificationResponse);
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }
}

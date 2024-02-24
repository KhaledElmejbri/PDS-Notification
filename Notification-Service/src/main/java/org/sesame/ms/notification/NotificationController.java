package org.sesame.ms.notification;

import org.sesame.ms.notification.beans.ProjectJoinNotification;
import org.sesame.ms.notification.configuration.NotificationHandler;
import org.sesame.ms.notification.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@RestController
//@EnableWebSocketMessageBroker
public class NotificationController {

    @Autowired
    private NotificationHandler notificationHandlerConfig;

    @Autowired
    private NotificationService notificationService;

    //@Autowired
   // private SimpMessagingTemplate template;

    @PostMapping("/sendNotification")
    public void sendNotification(String sessionId, @RequestBody ProjectJoinNotification request) {
        // Obtain WebSocketSession using session ID
        WebSocketSession session = notificationHandlerConfig.getSession(sessionId);
        if (session != null && session.isOpen()) {
            // Create a NotificationResponse object with appropriate data



            // Call the triggerNotification method to send the notification
            try {
              //  template.convertAndSendToUser(request.getSenderId(), "/queue/notifications", request);

                notificationService.triggerNotification(request, session);

            } catch (Exception e) {
                // Handle exception
                e.printStackTrace();
            }
        } else {
            // Handle invalid session or closed session
        }
    }
}

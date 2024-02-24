package org.sesame.ms.notification.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sesame.ms.notification.beans.ProjectJoinNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class NotificationHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper objectMapper;

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming messages
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Connection established logic
        sessions.put(session.getId(), session);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Connection closed logic
    }

    // Method to send notification containing response fields
    public void sendNotification(WebSocketSession session, ProjectJoinNotification notificationResponse) throws Exception {
        // Convert response object to JSON string
        String json = objectMapper.writeValueAsString(notificationResponse);
        // Send JSON string as a TextMessage over WebSocket
        session.sendMessage(new TextMessage(json));
    }

    public WebSocketSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }

}

package com.example.notification.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotificationConsumer {

    @KafkaListener(topics = "orders", groupId = "notification-group")
    public void notify(String message) {
        log.info("[NOTIFICATION] Sending notification for event: {}", message);
    }
}

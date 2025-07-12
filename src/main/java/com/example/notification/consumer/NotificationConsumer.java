package com.example.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationConsumer {

	private final ObservationRegistry observationRegistry;

	@KafkaListener(topics = "orders", groupId = "notification-group")
	public void notify(String message) {
		Observation.createNotStarted("notification.notify", observationRegistry)
				.lowCardinalityKeyValue("kafka.message", message).observe(() -> {
					log.info("[NOTIFICATION] Sending notification for event: {}", message);
				});
	}
}

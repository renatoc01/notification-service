package com.example.notification.consumer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.micrometer.observation.ObservationRegistry;

class NotificationConsumerTest {

	private NotificationConsumer consumer;

	@BeforeEach
	void setUp() {
		ObservationRegistry registry = ObservationRegistry.create();
		consumer = new NotificationConsumer(registry);
	}

	@Test
	void testNotify() {
		String message = "OrderShipped:{\"orderId\":\"123\"}";
		consumer.notify(message);
	}
}

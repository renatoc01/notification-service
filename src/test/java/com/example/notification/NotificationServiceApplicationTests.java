package com.example.notification;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {
		"spring.kafka.bootstrap-servers=localhost:9092",
		"management.zipkin.tracing.endpoint=http://localhost:9411/api/v2/spans"
	})
class NotificationServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

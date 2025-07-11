# 📬 Notification Service

This is the **Notification Microservice**, part of the Event-Sourced Microservices Architecture.  
Its responsibility is to **consume Kafka events from the `orders` topic** and simulate notification dispatching (e.g., email/SMS).

---

## 📦 Features

- ✅ Listens to Kafka topic `orders`
- 📥 Processes `OrderCreated` and `OrderShipped` events
- 🔔 Logs notifications simulating real-world behavior

---

## 🚀 Getting Started

To run the service individually (requires Kafka running):

```bash
./mvnw spring-boot:run
```

Or build and run with Docker:

```bash
docker build -t notification-service .
docker run -p 8082:8082 notification-service
```

The service listens on port 8082 by default.

## 🔗 Kafka Integration

- **Topic:** `orders`  
- **Group ID:** `notification-group`

When messages are received, the service logs a notification like:

```java
[NOTIFICATION] Sending notification for event: OrderCreated:{...}
```

## 🧪 Testing

This service includes a unit test for the consumer component.

To run the tests:

```bash
./mvnw test
```

## 📂 Directory Structure

```plaintext
notification-service/
├── src/
│   ├── main/
│   │   ├── java/com/example/notification/
│   │   │   └── consumer/NotificationConsumer.java
│   └── test/
│       └── java/com/example/notification/
│           └── consumer/NotificationConsumerTest.java
├── pom.xml
└── README.md
```
## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Kafka**
- **JUnit 5**
- **Docker**

## 🚀 CI/CD Pipeline

- Checkout Code: Clones the latest source code from the main branch.
- Set Up JDK 17: Installs Java 17 (Temurin distribution) needed for the build and tests.
- Maven Dependency Cache: Caches .m2 repository dependencies to accelerate build times.
- Permission Setup: Adds execute permissions to the Maven wrapper script (./mvnw).
- Build: Compiles and packages the application using Maven (./mvnw clean install).
- Test Execution: Runs unit tests to verify the code integrity.
- Docker Image Build: Builds a Docker image tagged as notification-service:latest for deployment.

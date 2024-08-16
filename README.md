
# Bank Web Application - Microservices Architecture
## Overview

This project is a backend bank web application developed using microservices architecture. It leverages Spring Boot for building the microservices, Docker for containerization, and Kubernetes for orchestration. The application is designed to be scalable, resilient, and cloud-native, following best practices in modern software development.

## Features

* **Microservices Architecture**: The application is designed using microservices, allowing each service to be independently developed, deployed, and scaled.

* **Cloud-Native**: The application adheres to the 15-factor methodology, ensuring it is robust, scalable, and maintainable in cloud environments.

* **Service Discovery**: Services are registered and discovered using Spring Eureka Server, facilitating efficient communication between microservices.

* **Configuration Management**: Spring Cloud Config Server is used for centralized and dynamic configuration management across all services.

* **Resilience**: The application is built with resilience in mind using the RESILIENCE4J framework, implementing features like circuit breakers, retries, and fallbacks.

* **Observability**: The application is monitored using Prometheus, Grafana, Loki, Promtail, and Tempo, providing insights into system performance and helping with troubleshooting.

* **Event-Driven Architecture**: The application supports asynchronous communication using RabbitMQ, Kafka, Spring Cloud Functions, and Spring Cloud Stream.

* **Containerization**: Each microservice is containerized using Docker, ensuring consistency across development, testing, and production environments.



## Technologies Used

    
* Java: Core programming language for developing the microservices.
    
* Spring Boot: Framework for building microservices with ease.
    
* Spring Cloud: Provides tools for managing configurations, service discovery, and more.
    
* Docker: Containerization of microservices for consistent deployment.
    
* Prometheus & Grafana: Monitoring and observability tools.
    
* RabbitMQ & Kafka: Message brokers used for event-driven architecture.
    
* RESILIENCE4J: Framework for building resilient microservices.
    
* OAuth2 & OpenID Connect: For securing the microservices.

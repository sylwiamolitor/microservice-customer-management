# Microservices Application

This repository hosts a microservices-based application using Service Discovery, Load Balancing, Spring Cloud, Spring Cloud Gateway, Eureka, and Spring Boot. The project is a practical implementation to demonstrate microservices architecture patterns.

## Table of Contents
- [General Information](#general-information)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Screenshots](#screenshots)
- [Setup](#setup)
- [Usage](#usage)
- [Project Status](#project-status)
- [Room for Improvement](#room-for-improvement)

## General Information
This project was developed as a hands-on exercise in microservices, demonstrating key architectural principles and patterns.

## Technologies Used
- Java
- Eureka Server
- Docker
- Spring Framework (Spring Boot, Spring Cloud)
- OpenAPI / Swagger
- Spring Cloud Gateway

## Features
- Create a customer via a RESTful API.
- Validate email format and check for duplicate email addresses.
- Basic fraud-check microservice example.

## Screenshots
![Customer Creation Screenshot](img_1.png)
![Fraud Check Screenshot](img_2.png)

## Setup
Before running the application, set the following environment variables (example values shown):

- `DATABASE_URL`: JDBC URL for the database, e.g. `jdbc:postgresql://localhost:5432/your_db`
- `DATABASE_USERNAME`: Database username (e.g., `postgres`)
- `DATABASE_PASSWORD`: Database password
- (Optional) `DATABASE_NAME`: Database name if used separately in your configuration

Ensure the database is accessible and credentials are correct.

To build and start the application using Docker Compose (from the repository root):
```bash
docker-compose up --build
```
This will build the project images and start the services defined in `docker-compose.yml`.

## Usage
- Create a customer (POST):
  http://localhost:8090/api/v1/customers

- Check fraud status for a customer (GET):
  http://localhost:8090/api/v1/fraud-check/{customerId}

- API documentation (Swagger / OpenAPI):
  http://localhost:8090/swagger-ui/index.html

## Project Status
The project is currently completed.

## Room for Improvement
Potential extensions:
- Add more microservices and inter-service communication examples.
- Implement distributed tracing and centralized logging.
- Add automated tests and CI/CD pipeline.

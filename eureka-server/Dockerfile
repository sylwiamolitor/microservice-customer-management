FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/eureka-server-3.3.3.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]


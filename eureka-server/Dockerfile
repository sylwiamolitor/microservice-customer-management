FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY target/eureka-server-3.5.6.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]


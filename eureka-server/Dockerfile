FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY target/eureka-server-1.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]


FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/gateway-service-3.3.3.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
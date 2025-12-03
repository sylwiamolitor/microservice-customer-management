FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY target/gateway-service-3.5.6.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
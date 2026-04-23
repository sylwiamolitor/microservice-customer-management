FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY target/gateway-service-1.1-SNAPSHOT.jar gateway-service.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/customer-3.3.3.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
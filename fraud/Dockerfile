FROM openjdk:17-jdk-slim
WORKDIR /app
COPY /target/fraud-3.3.3.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY /target/fraud-3.5.6.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
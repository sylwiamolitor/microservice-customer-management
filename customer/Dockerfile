FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY /target/customer-3.5.6.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "app.jar"]
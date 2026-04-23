FROM openjdk:26-ea-jdk-slim
WORKDIR /app
COPY target/fraud-1.1-SNAPSHOT.jar fraud.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "fraud.jar"]

FROM eclipse-temurin:26-jre-alpine
WORKDIR /app
COPY target/customer-1.1-SNAPSHOT.jar customer.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "customer.jar"]

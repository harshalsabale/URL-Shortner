FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/url-shortner-1.0.0-SNAPSHOT.jar url-shortner.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "url-shortner.jar"]
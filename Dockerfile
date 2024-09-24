FROM openjdk:21-jdk
EXPOSE 8080
LABEL authors="feuzme"
COPY . .
RUN ./mvnw clean install
CMD ["java", "-jar", "./target/monorepo-0.0.1-SNAPSHOT.jar"]



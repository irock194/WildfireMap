# FROM openjdk:17-jdk-alpine
# ADD target/docker-spring-boot.jar docker-spring-boot.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]

FROM maven:3.8.2-jdk-11

WORKDIR /wildfire-app
COPY . .
RUN mvn clean install

EXPOSE 5000

CMD mvn spring-boot:run

FROM gradle:4.3.0-jdk8-alpine as build

RUN mkdir /app

RUN gradle build --no-daemon

FROM openjdk:8-jdk-alpine

ADD target/pyo-service.jar app/pyo-service.jar

ENTRYPOINT ["java","-jar","/app/pyo-service.jar"]
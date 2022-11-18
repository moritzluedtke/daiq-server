FROM gradle:7.5.1-jdk17-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build

FROM eclipse-temurin:17.0.5_8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/*RELEASE.jar ./server.jar
CMD ["java", "-jar", "server.jar"]

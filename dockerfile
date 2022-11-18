FROM eclipse-temurin:17.0.5_8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY build/libs/*RELEASE.jar ./server.jar
CMD ["java", "-jar", "server.jar"]

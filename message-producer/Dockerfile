FROM eclipse-temurin:21-jre-jammy
LABEL maintainer="trepudox"
WORKDIR /usr/src
COPY target/message-producer-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
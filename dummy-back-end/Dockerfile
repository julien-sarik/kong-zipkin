FROM docker.io/maven:3.9.9-eclipse-temurin-23-alpine as builder

RUN mkdir /src
COPY src /src/
COPY pom.xml /pom.xml

RUN mvn install


FROM docker.io/maven:3.9.9-eclipse-temurin-23-alpine
COPY --from=builder /target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
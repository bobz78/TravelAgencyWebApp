# Stage 1: Build WAR using Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run with Tomcat
FROM tomcat:9.0-jdk17
COPY --from=build /app/target/TravelAgencyWebApp-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8082

CMD ["catalina.sh", "run"]
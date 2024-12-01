# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to the working directory
COPY pom.xml mvnw* ./

# Copy the entire .mvn directory (for Maven wrapper)
COPY .mvn .mvn

# Download dependencies (this step caches dependencies for faster builds)
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the application to the working directory
COPY src src
COPY target target

# Expose the application port (assuming 8080 for Spring Boot)
EXPOSE 8000

# Copy the built JAR file into the container
COPY target/student-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

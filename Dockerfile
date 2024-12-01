# Use a lightweight OpenJDK image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR file into the container
COPY target/student-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8000

# Run the application
CMD ["java", "-jar", "app.jar"]

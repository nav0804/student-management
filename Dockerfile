FROM openjdk:21-jdk-slim
EXPOSE 8000
ADD ./target/student-management.jar student-management.jar
ENTRYPOINT ["java", "-jar", "/student-management.jar"]

# Use a slim JDK base
FROM openjdk:17-jdk-slim

# Set working  comment
WORKDIR /app

# Tell Docker (and Cloud Run) which port we’ll listen on
EXPOSE 8081

# Copy the fat-jar built by Maven into the image
COPY target/*.jar app.jar

# Launch the jar
ENTRYPOINT ["java", "-jar", "app.jar"]

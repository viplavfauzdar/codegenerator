# Use an official openjdk runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container to /app
WORKDIR /

# Copy the jar file from the build stage
COPY ./build/libs/codegenerator-0.0.1-SNAPSHOT.jar /

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file 
ENTRYPOINT ["java","-jar","/codegenerator-0.0.1-SNAPSHOT.jar"]
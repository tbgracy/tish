# Use the official Maven image as base image
FROM maven:3.8.4-jdk-8 AS builder

# Copy the project files to the container
COPY . /usr/src/app
WORKDIR /usr/src/app

# Build the project with Maven
RUN mvn clean package

# Use the official Tomcat 9 image as base image
FROM tomcat:9-jdk8-openjdk-slim

# Remove the default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file from the Maven image to the Tomcat image
COPY --from=builder /usr/src/app/target/tish-webapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/tish-webapp.war

# Copy your database file to the root directory of Tomcat
COPY ./tish.db /usr/local/tomcat

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]


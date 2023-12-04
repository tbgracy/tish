# Use the official Tomcat base image
FROM tomcat:latest

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory to /app
WORKDIR /app

# Copy the source code to the container
COPY ./src /app

# Build the project
RUN mvn clean install

# Copy the generated WAR file to the webapps directory
RUN cp /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Copy your database file to the root directory
COPY ./tish.db /usr/local/tomcat

# Expose the port that Tomcat will run on
EXPOSE 8080

# Start Tomcat when the container starts
CMD ["catalina.sh", "run"]
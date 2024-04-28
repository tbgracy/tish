# Use the official Tomcat 9 image as base image
FROM tomcat:9-jdk8-openjdk-slim

# Set environment variables
ENV MAVEN_VERSION=3.8.4 \
    MAVEN_HOME=/usr/share/maven \
    MAVEN_REPO=/root/.m2

# Install Maven
RUN apt-get update && \
    apt-get install -y wget && \
    wget -q "https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" && \
    tar -xzf "apache-maven-${MAVEN_VERSION}-bin.tar.gz" && \
    mv "apache-maven-${MAVEN_VERSION}" "${MAVEN_HOME}" && \
    ln -s "${MAVEN_HOME}/bin/mvn" /usr/bin/mvn && \
    rm -f "apache-maven-${MAVEN_VERSION}-bin.tar.gz"

# Copy the project files to the container
COPY . /usr/src/app
WORKDIR /usr/src/app

# Build the project with Maven
RUN mvn clean package

# Remove the default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your database file to the root directory
COPY ./tish.db /usr/local/tomcat

# Deploy the WAR file to Tomcat
RUN cp target/tish-webapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/tish-webapp.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]

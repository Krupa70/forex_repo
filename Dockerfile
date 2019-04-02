# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# copy WAR into image
COPY target/microservice-forex-service-0.0.1-SNAPSHOT.jar /app.war 
COPY logback.xml /logback.xml

# run application with this command line 
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "-Dlogging.config=/logback.xml", "/"]
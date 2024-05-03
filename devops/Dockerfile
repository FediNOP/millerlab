FROM maven:3.9.6-eclipse-temurin-21 AS app
WORKDIR /app
USER root
COPY /target/millerlab-application.jar /app/millerlab-application.jar
CMD [ "sh", "-c", "java $JAVA_OPTS -jar -Dspring.profiles.active=deploy /app/millerlab-application.jar" ]
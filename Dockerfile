FROM openjdk:8u111-jdk-alpine
ARG PROFILE=@MVNPROFILE@
ENV PROFILE $PROFILE
VOLUME /tmp
RUN mkdir -p /etc/app-config
ADD /target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -server -Djava.awt.headless=true -Dawt.toolkit=sun.awt.HToolkit -Djava.security.egd=file:/dev/./urandom -jar /app.jar --spring.config.location=file:///etc/app-config/ --spring.profiles.active=$PROFILE

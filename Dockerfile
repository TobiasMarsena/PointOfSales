FROM openjdk:8-jdk-alpine

VOLUME /tmp

ADD /target/pointofsales-0.0.1-SNAPSHOT.jar pointofsales-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "pointofsales-0.1.1-SNAPSHOT.jar"]
FROM openjdk:17-oracle
WORKDIR /devd0ne
COPY build/libs/expert-system-0.0.1-SNAPSHOT.jar expert-system.jar
ENTRYPOINT ["java", "-jar", "expert-system.jar"]
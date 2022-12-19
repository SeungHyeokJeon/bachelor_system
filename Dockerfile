FROM openjdk:11-jdk
ENTRYPOINT ["java", "-jar", "./build/libs/hs_back-0.0.1-SNAPSHOT.jar"]
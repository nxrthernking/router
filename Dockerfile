FROM amazoncorretto:11-alpine-jdk
ARG JAR_FILE=*.jar
COPY target/test-0.0.1-SNAPSHOT.jar router.jar
ENTRYPOINT ["java","-jar","/router.jar"]
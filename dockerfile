FROM amazoncorretto:17-alpine-jdk
COPY target/api-boot-0.0.1-SNAPSHOT.jar apiboot-server-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/apiboot-server-1.0.0.jar"]

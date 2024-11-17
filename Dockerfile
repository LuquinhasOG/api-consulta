FROM openjdk:21
ADD ./api.jar api.jar
ENTRYPOINT ["java", "jar", "api.jar"]
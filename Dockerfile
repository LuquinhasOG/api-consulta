FROM openjdk:21
ADD ./build/api.jar api.jar
ENTRYPOINT ["java", "jar", "api.jar"]
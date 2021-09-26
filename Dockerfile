FROM openjdk:16
EXPOSE 8091
ADD target/spring-docker-task.jar spring-docker-task.jar
ENTRYPOINT ["java", "-jar", "spring-docker-task.jar"]
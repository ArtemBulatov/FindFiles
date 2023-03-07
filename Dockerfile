FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} FindFilesApp.jar
ENTRYPOINT ["java","-Xms32m","-Xmx64m","-jar","FindFilesApp.jar"]

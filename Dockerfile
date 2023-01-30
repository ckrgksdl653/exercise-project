FROM lpicanco/java11-alpine
ARG JAR_FILE=./api/build/libs/*.jar
COPY ${JAR_FILE} exercise.jar
ENTRYPOINT ["java", "-jar", "exercise.jar"]

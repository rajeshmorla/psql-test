FROM openjdk:8
ADD target/psql-test-0.0.1-SNAPSHOT.jar psql-test-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "psql-test-0.0.1-SNAPSHOT.jar"]

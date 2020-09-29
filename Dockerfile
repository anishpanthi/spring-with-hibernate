#Add openjdk
FROM openjdk:11
ADD build/libs/spring-with-hibernate-0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]

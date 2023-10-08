FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN mvn clean
RUN mvn install
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
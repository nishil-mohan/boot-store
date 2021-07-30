FROM openjdk:8
RUN mkdir -p /app/
WORKDIR /app
COPY target/*.jar /app/application.jar
EXPOSE 8086
ENTRYPOINT [ "java","-jar","/app/application.jar" ]

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/*.jar /app/myapp.jar

EXPOSE 8080

CMD ["java","-jar","/app/myapp.jar"]
FROM openjdk:11
EXPOSE 8080
ADD target/invoice-app.jar invoice-app.jar
ENTRYPOINT ["java","-jar","/invoice-app.jar"]
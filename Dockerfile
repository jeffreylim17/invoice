FROM openjdk:11
EXPOSE 8081
ADD target/invoice-app.jar invoice-app.jar
ENTRYPOINT ["java","-jar","/invoice-app.jar"]
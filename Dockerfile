FROM openjdk:11
EXPOSE 8080
ADD target/invoice-0.0.1-SNAPSHOT.jar invoice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/invoice-0.0.1-SNAPSHOT.jar"]
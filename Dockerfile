FROM openjdk:11-oracle
ADD target/app-0.0.1-SNAPSHOT.jar reviews-app.jar
ENTRYPOINT ["java", "-jar", "reviews-app.jar"]

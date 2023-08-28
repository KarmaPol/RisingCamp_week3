FROM openjdk:11-jdk
WORKDIR /usr/src/app
ENTRYPOINT ["java", "-jar", "-Dspring.config.location=classpath:/application.yml, classpath:/application-real.yml, classpath:/application-real-db.yml", "-Dspring.profiles.active=production"]
CMD ["/usr/src/app/build/libs/demo-0.0.1-SNAPSHOT.jar"]
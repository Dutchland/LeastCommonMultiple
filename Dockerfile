FROM openjdk:8
ADD target/leastcommonmultiple.jar leastcommonmultiple.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "leastcommonmultiple.jar"]
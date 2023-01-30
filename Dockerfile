FROM openjdk:11
COPY target/*.jar advertiser.jar
CMD java -jar advertiser.jar

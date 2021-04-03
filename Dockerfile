FROM java:8
ADD /target/easycode-0.0.1-SNAPSHOT.jar test.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","test.jar"]
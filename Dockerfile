FROM openjdk:17
EXPOSE 8081
ADD /target /root
ENTRYPOINT ["java","-jar", "/allshoesbackoperador.jar"]
# Usa una imagen base de OpenJDK 21 de Amazon Corretto
FROM amazoncorretto:21
# Establece el directorio de trabajo en el contenedor
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/votify-user-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
LABEL authors="Gabriel"

ENTRYPOINT ["java","-jar","/app.jar"]
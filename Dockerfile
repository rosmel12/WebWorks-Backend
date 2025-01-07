#IMAGEN MOD ELO
FROM openjdk:17-slim

# RAIZ DE CONTENEDOR
WORKDIR /root

#COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEOR
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

#DESCARGAR LAS DEPENDENCIAS
RUN ./mvnw dependency:go-offline

#COPIAR EL CODIGO FUENTE
COPY ./src /root/src

#CONSTRUIR APP
RUN ./mvnw clean package -DskipTests

#
COPY target/WebWorks-Backend-0.0.1-SNAPSHOT.jar /root/webworks-backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/root/webworks-backend.jar"]

#Equivalente FROM mysql:8.0.18
#Nos descargamos el contenedor ofiial de Open JDK, solo el proyecto JRE
FROM openjdk:8-jre-slim
# Definimos variable
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /api-rest-usuarios.jar
CMD java -jar /api-rest-usuarios.jar
FROM openjdk:11-slim
WORKDIR /opt/spring-cloud-playground
COPY target/core-api-gateway-server-0.0.1.jar .
ENTRYPOINT ["java","-jar","core-api-gateway-server-0.0.1.jar"]
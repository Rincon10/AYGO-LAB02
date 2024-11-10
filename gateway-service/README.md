# Manual para Compilar y Ejecutar un Servicio Gateway con Spring Netflix Gateway

Este manual te guiará para compilar y ejecutar un **servicio Gateway** basado en **Spring Netflix Gateway** utilizando Maven.


## Compilar el Proyecto con Maven

n el directorio raíz del proyecto, ejecuta el siguiente comando

```bash
mvn clean install
```

### Paso 3: Comandos para ejecutar la aplicacion

>[!IMPORTANT]
Para que el proyecto se inicie correctamente sin ninguna excepción, es necesario iniciar primero el servicio de discovery. Esto permite que los diferentes servicios sepan a qué URL hacer las solicitudes. En caso de que no esté en ejecución, consulta el siguiente [README](../discovery-service/README.md).

Para ejecutar el proyecto usa el siguiente comando:

### Windows


```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes;target/dependency/*" com.escuelaing.edu.co.distribuited_systems.servicio_gateway.ServicioGatewayApplication
```

### Linux

```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes:target/dependency/*" com.escuelaing.edu.co.distribuited_systems.servicio_gateway.ServicioGatewayApplication
```


para verificar el funcionamiento del servicio revisar el puerto 8090


para tener enrutamiento dinamico, se establecio el siguiente archivo

```yml
spring:
  cloud:
    gateway:
      routes:
        - id: ride-service
          uri: lb://ride-service
          predicates:
            - Path=/api/v1/rides/**
          filters:
            - StripPrefix=3

        - id: driver-service
          uri: lb://driver-service
          predicates:
            - Path=/api/v1/drivers/**
          filters:
            - StripPrefix=3

        - id: payment-service
          uri: lb://payment-service
          predicates:
            - Path=/api/v1/payments/**
          filters:
            - StripPrefix=3

        - id: user-service
          uri: lb://user-service
          predicates:
            - Path=/api/v1/users/**
          filters:
            - StripPrefix=3
```
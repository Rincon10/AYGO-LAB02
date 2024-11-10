# Payment Service

>[!IMPORTANT]
Para que el proyecto se inicie correctamente sin ninguna excepción, es necesario iniciar primero el servicio de discovery. Esto permite que los diferentes servicios sepan a qué URL hacer las solicitudes. En caso de que no esté en ejecución, consulta el siguiente [manual](../discovery-service/README.md)

## Compilar el Proyecto con Maven

En el directorio raíz del proyecto, ejecuta el siguiente comando

```bash
mvn clean install
```

###  Comandos para ejecutar la aplicacion

Para ejecutar el proyecto y establecer la variable de entorno URL_EUREKA_SERVER, usa el siguiente comando:

### Windows


```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes;target/dependency/*" com.uber.clone.PaymentServiceApplication
```

### Linux

```bash
URL_EUREKA_SERVER=http://localhost:8761/eureka java -cp "target/classes:target/dependency/*" com.uber.clone.PaymentServiceApplication
```

## Uris de ride service

Para explicar los respectivos uris de este recurso nos podemos apoyar de swagger-ui, para poder acceder a este bastara con colocar

```bash
http://localhost:51627/swagger-ui/index.html
```


si todo sale bien veremos lo siguiente 

![alt text](../docs/img/07-uri-recursos-ride-service.png)

## Representacion del recurso

representacion de un viaje

```json
{
  "id": 5,
  "amount": 0,
  "paymentStatus": "PENDING",
  "ride": {
    "id": 1,
    "userId": 123456,
    "driverId": 654321,
    "pickupLocation": "123 Street",
    "dropOffLocation": "321 Street",
    "fare": 45000,
    "paymentId": "payment-id",
    "rideStatus": "IN_PROGRESS"
  }
}
```
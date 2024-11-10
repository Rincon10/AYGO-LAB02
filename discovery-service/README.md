## Compilar el Proyecto con Maven

n el directorio raíz del proyecto, ejecuta el siguiente comando

```bash
mvn clean install
```

### Comandos para ejecutar la aplicacion

Para ejecutar el proyecto usa el siguiente comando:

### Windows


```bash
java -cp "target/classes;target/dependency/*" com.uber.clone.DiscoveryServiceServerApplication
```

### Linux

```bash
java -cp "target/classes:target/dependency/*" com.uber.clone.DiscoveryServiceServerApplication
```

si, todo ejecuta de manera correcta deberia ver el siguiente log



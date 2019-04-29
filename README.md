# Trabalho final microserviços


## Inicializar projeto

```sh
mvn sprint-boot:run
```

### Gerar container

```sh
./mvnw install dockerfile:build
```

### Rodar container

```sh
docker run -p 8080:8080 -t adrianolaselva/mba-trabalho-final-microservices:1.0.0
```

## Api

#### Inserir transação

```sh
curl -X POST \
  http://localhost:8080/transactions \
  -H 'content-type: application/json' \
  -d '{
    "timestamp": 1478221904000,
    "amount": 25000.15
}'
```

#### Listar estatísticas

```sh
curl -X GET \
  http://localhost:8080/statistics \
  -H 'content-type: application/json'
```

# Microservicio Spring Boot

Este proyecto es un microservicio desarrollado con Java y Spring Boot que expone dos endpoints REST:

- `GET` con `PathVariable`
- `POST` con `RequestBody`

---

## Tecnologías

- Java 17
- Spring Boot 3
- gradle
- Spring Web

---

 Ejecutar el proyecto

### Clonar repositorio

```bash
git clone https://github.com/rogeliohdezglez93-dev/desarrolloprueba.git

### generar JAR

cd desarrolloprueba
git checkout master
./gradlew bootJar
java -jar build/libs/pruebatecnica-0.0.1-SNAPSHOT.jar

### ejecutar los endPoint GET caso 200

curl --location 'localhost:8080/api/pet/6'
##Respuesta
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 25 May 2026 16:21:51 GMT

{"id":6,"name":"CMDR","status":"available"}
#############################################################

### ejecutar los endPoint GET caso 404

curl -i --location 'localhost:8080/api/pet/199'
##Respuesta
HTTP/1.1 404 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 25 May 2026 16:22:47 GMT

{"timestamp":"2026-05-25T16:22:47.497+00:00","status":404,"error":"Not Found","path":"/api/pet/199"}
##############################################################

### ejecutar endPoint POST caso 200

curl -i --location 'localhost:8080/api/pet' --header 'Content-Type: application/json' --data '{
"id": 15,
"status": "available",
"name": "cat"
}'
##Respuesta
HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Mon, 25 May 2026 16:23:08 GMT

{"transactionId":"13070ef6-ca7c-4c24-9032-e4b37a4c3e1f","dateCreated":"2026-05-25T10:23:08.848997","status":true,"name":"cat"}


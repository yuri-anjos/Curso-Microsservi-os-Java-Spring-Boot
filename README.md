# Curso1
Microsserviços Java 11 com Spring Boot e Spring Cloud

Utilização de Feign, Ribbon, Hystrix, OAuth, JWT, Discovery Server Eureka, API Gateway Zuul, Config Server...

# Como configurar e rodar a aplicação

### Como rodar o projeto inteiro no docker

- Utilizar o profile prod.
- Empacotar os serviços com o comando "mvn clean package -DskipTests=true".
- No diretorio do arquivo docker-compose.yaml executar o comando "docker compose up".

### Como rodar o projeto local

- Utilizar o profile dev ou test.
- Rodar as aplicações (o eureka-server e config-server devem ser executados primeiro).

Caso utilize o profile dev, deve estar rodando o postgres na sua máquina, pode ser através do docker com os comandos:

- docker run -p 5432:5432 --name hr-worker-postgres -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker --network hr-network --rm -d postgres:12-alpine
- docker run -p 5433:5432 --name hr-user-postgres -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user --network hr-network --rm -d postgres:12-alpine

### Profiles

Nos arquivos application.properties de hr-worker e hr-user você pode alterar o Profile do Spring.

- spring.profiles.active=dev -> serve para rodar a aplicação local com postgreSQL.
- spring.profiles.active=test -> serve para rodar a aplicação local mas sem utilizar o postgreSQL.
- spring.profiles.active=prod -> deve ser utilizado para subir a aplicação inteira no docker, pois aponta ao postgreSQL do docker.

### Eureka Server

Eureka Server: http://localhost:8761

- Pode ser acessado para validar a integração com os microserviços

### Postman

Coleção: files/ms-course.postman_collection.json
Environment: files/ms-course-env.postman_environment.json

Para testar a aplicação através do postman voce deve realizar o Login e você estárá livre para testar as outras requisições.

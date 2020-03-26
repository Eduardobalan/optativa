# Readme

## Repositório relacionados:

https://github.com/Eduardobalan/albus
https://github.com/Eduardobalan/albus-api

## Dependências Necessárias

 - Java JDK
 - Maven
 - Doker
 - Docker-compose version 3.1 ou superior

## Configurando o projeto.

 - Clone o projeto Albus-api.
 - Compile o projeto utilizando o maven
 
## Configurando o Docker.
 - No diretório do projeto, execute o arquivo "docker-start.sh".
 
 Após a execução 3 novos container estarão disponíveis:
 
 - albus_portainer_1 - http://localhost:9001
 - albus_sonarqube_1 - http://localhost:9000
 - albus_postgreSQL_1 - porta 5433

## Comandos:

### Executar o Sonar

 - mvn install -Pdist sonar:sonar
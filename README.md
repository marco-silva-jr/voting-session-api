# Voting Session API

Gerenciar e participar de sessões de votação.

## Descrição

Este projeto é uma API para gerenciar e participar de sessões de votação, construída usando Spring Boot. Ele fornece endpoints para criar, ler, atualizar e excluir informações relacionadas a sessões de votação.

## Tecnologias

- **Java**: 17
- **Spring Boot**: 3.3.3
- **Banco de Dados**: PostgreSQL
- **Flyway**: Para migrações de banco de dados
- **SpringDoc OpenAPI**: Para documentação da API
- **Lombok**: Para reduzir o código boilerplate

## Pré-requisitos

Certifique-se de ter o [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) e [PostgreSQL](https://www.postgresql.org/download/) instalados em sua máquina.

## Instalação

Clone este repositório:

```bash
git clone https://github.com/marco-silva-jr/voting-session-api.git
cd voting-session-api

mvn clean install
mvn spring-boot:run
```

## Configuração do Banco de Dados
O Flyway será usado para gerenciar as migrações do banco de dados. Certifique-se de configurar seu banco de dados PostgreSQL e ajustar as configurações no arquivo src/main/resources/application.properties ou application.yml.

Exemplo de configuração no application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## Uso
A API expõe os seguintes endpoints:

- POST /salvar - Salva um novo associado.
- GET /{id} - Obtém um associado pelo ID.

Para mais detalhes sobre os endpoints e a documentação, acesse Swagger UI quando a aplicação estiver em execução.

## Contato
Para perguntas ou comentários, entre em contato com marco.junior.ti@gmail.com


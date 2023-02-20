# Aplicação de Microserviço para Cliente

Esta aplicação é um microserviço de gerenciamento de clientes, responsável por permitir a criação, recuperação e atualização de informações de clientes. O microserviço é construído em Java com a utilização do framework Spring Boot.

## Estrutura

O microserviço é dividido em diversas camadas, cada uma com uma responsabilidade específica. A camada de aplicação é composta pelas classes que recebem e respondem às requisições HTTP, enquanto que a camada de domínio possui as regras de negócio e entidades que representam as informações do cliente. Além disso, o microserviço possui uma camada de serviço responsável por intermediar a comunicação entre as camadas de aplicação e domínio.

## Endpoints

O microserviço possui os seguintes endpoints:

- GET /clientes
Este endpoint retorna uma mensagem informando que a API está funcionando corretamente.

- POST /clientes
Este endpoint é responsável por criar um novo cliente na base de dados. O cliente é recebido no corpo da requisição no formato JSON. O endpoint retorna o código de status 201 CREATED, caso o cliente seja criado com sucesso, ou um código de erro, caso ocorra algum problema.

- GET /clientes?cpf={cpf}
Este endpoint é utilizado para recuperar as informações de um cliente a partir do seu CPF. O CPF é passado como parâmetro na URL. O endpoint retorna o código de status 200 OK, juntamente com as informações do cliente em caso de sucesso. Caso o cliente não seja encontrado, o endpoint retorna o código de status 404 NOT FOUND.

## Tecnologias

O microserviço é construído em Java, utilizando o framework Spring Boot. Além disso, são utilizadas as bibliotecas Lombok e Slf4j para facilitar a escrita do código e logging, respectivamente. A base de dados é implementada em memória com o uso do H2.

## Como executar

Para executar o microserviço, é necessário ter o Java 11 instalado. Em seguida, basta executar o comando `./mvnw spring-boot:run` na raiz do projeto. O microserviço será executado na porta 8080.

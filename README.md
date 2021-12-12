# HeroisMarvel
Uma API que salva, recupera e deleta herois da marvel em banco de dados DynamoDB testado localmente.
Esta é aplicação Spring Web Flux: utiliza as classes Mono e Flux para comunicação com o banco de dados.

#Uso:
Para rodar o dynamodb, precisa ser em modo administrador.
Código: java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar

Para criar o projeto no Spring Initializr (start.spring.io), baixar as dependências:
 - Lombok
 - Spring Reactive Web

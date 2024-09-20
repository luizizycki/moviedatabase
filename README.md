# moviedatabase
O MovieDatabase é um projeto em Java para gerenciar informações sobre filmes e usuários. Permite adicionar, editar e excluir registros, utilizei Maven para o gerenciamento do projeto e MySQL como banco de dados.<br>
O aplicativo é atualmente gerenciado por CLI, entretanto sempre há espaço para melhorias<br>
## Objetivo do projeto
 Serviu para aplicar o que aprendi sobre programação orientada a objetos e Java. Durante o desenvolvimento, pratiquei bastante com classes, herança e encapsulamento. Também ganhei experiência com o MySQL, lidando com conexões, dados e consultas, o que me ajudou a entender melhor como a aplicação interage com o banco de dados.
 ## Imagens:
 
![image](https://github.com/user-attachments/assets/34b26878-3f42-4001-b6c8-07020f0aa2d9)

![image](https://github.com/user-attachments/assets/9d48de1d-431f-4820-b50a-a60cdf943a23)

## Dependências
Este projeto utiliza o Maven para gerenciamento de dependências. Para usar o MySQL como banco de dados:
```xml
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.2.0</version>
    </dependency>
```
Além disso, no arquivo ``db.sql`` há a estrutura do banco de dados, assim como alguns dados de exemplo.

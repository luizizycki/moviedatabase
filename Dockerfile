# Puxando maven e openjdk-11
FROM maven:3.6.3-jdk-11 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline #baixa todas as dependências do maven

COPY src/ /app/src/
RUN mvn package -DskipTests

# importando a imagem que realmente vai rodar o jar
FROM openjdk:11-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar /app/

EXPOSE 8080

# Entrypoint para executar o jar automaticamente
ENTRYPOINT ["java", "-jar", "movie-database.jar"]
